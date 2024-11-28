package com.tasks.tasks.services.tasks;

import com.tasks.tasks.auth.repo.AuthRepository;
import com.tasks.tasks.dto.tasks.CreateTaskDto;
import com.tasks.tasks.dto.tasks.FindTaskResDto;
import com.tasks.tasks.dto.tasks.UpdateTaskStatusDto;
import com.tasks.tasks.exceptions.ResourceNotFoundException;
import com.tasks.tasks.exceptions.UnauthorizedException;
import com.tasks.tasks.model.Tag;
import com.tasks.tasks.model.Task;
import com.tasks.tasks.model.User;
import com.tasks.tasks.repository.TaskRepository;
import com.tasks.tasks.repository.UserRepository;
import com.tasks.tasks.services.tags.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final AuthRepository authRepository;
    private final TaskRepository taskRepository;
    private final TagService tagService;

    @Transactional
    @Override
    public String createTask(CreateTaskDto createTaskDto, String username) {
        //        fetch task owner
        User task_owner = authRepository.findByUsername(username)
                .orElseThrow(() -> new  UsernameNotFoundException("User not found!"));

    //        get tags if any and create them first
        List<String> task_tags = createTaskDto.getTags();

    //        create task tags
            Set<Tag> tags = task_tags.isEmpty() ?
                    new HashSet<>():
                    tagService.findOrCreateTags(task_tags);

    //create and save task
        Task new_task = new Task();
        new_task.setTitle(createTaskDto.getTitle());
        new_task.setDescription(createTaskDto.getDescription());
        new_task.setStatus(createTaskDto.getStatus());
        new_task.setTags(tags);
        new_task.setUser(task_owner);

        taskRepository.save(new_task);

        return "Task created successfully";
    }


    @Override
    public List<FindTaskResDto> findUserTasks(int page, int pageSize, Long userId) {
             int limit = pageSize;
            int offset = (page - pageSize) * limit;

            return taskRepository.findUserTasks( limit, offset, userId);
    }

    @Transactional
    @Override
    public String updateTaskStatus(UpdateTaskStatusDto updateTaskStatusDto, Long taskId, Long userId) {
        //        check if the task exists
        Task task_to_update = taskRepository.findById(taskId)
                               .orElseThrow(() -> new ResourceNotFoundException("Task not found!"));
        //        verify ownership
        //        TODO: implement role based access instead
        if (!Objects.equals(task_to_update.getUser().getId(), userId)){
            throw new UnauthorizedException("Not authorized");
        }

        try {
            // Update the task status
            task_to_update.setStatus(updateTaskStatusDto.getStatus());
            taskRepository.save(task_to_update);

            return "Status updated successfully";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    @Override
    public String updateTask(CreateTaskDto  updateTaskDto, Long taskId, Long userId) {
        // check if the task exists
        Task task_to_update = taskRepository.findById(taskId)
                                   .orElseThrow(() -> new ResourceNotFoundException("Task not found!"));

        // Verify task ownership
         if (!Objects.equals(task_to_update.getUser().getId(), userId)){
            throw new UnauthorizedException("Not authorized");
        }
        try {
            // get tags if any and create them first
            List<String> task_tags = updateTaskDto.getTags();

            // create task tags
            Set<Tag> tags = task_tags.isEmpty() ?
                    new HashSet<>():
                    tagService.findOrCreateTags(task_tags);


            //  update task
            task_to_update.setTitle(updateTaskDto.getTitle());
            task_to_update.setDescription(updateTaskDto.getDescription());
            task_to_update.setStatus(updateTaskDto.getStatus());
            task_to_update.setTags(tags);

            taskRepository.save(task_to_update);
            return "Task updated successfully";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    @Override
    public String deleteTask(Long taskId, Long userId) {
//        check if the task exists
        Task task_to_delete = taskRepository.findById(taskId)
                                .orElseThrow(() -> new ResourceNotFoundException("Task not found!"));
        //        Verify task ownership
//        TODO: implement role based access instead
        if (!Objects.equals(task_to_delete.getUser().getId(), userId)){
            throw new UnauthorizedException("Not authorized");
        }

        try {

            taskRepository.deleteById(taskId);
            return "Task deleted successfully";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

    }
}
