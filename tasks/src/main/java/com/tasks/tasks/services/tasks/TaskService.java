package com.tasks.tasks.services.tasks;

import com.tasks.tasks.auth.repo.AuthRepository;
import com.tasks.tasks.dto.tags.FindTagsResDto;
import com.tasks.tasks.dto.tasks.CreateTaskDto;
import com.tasks.tasks.dto.tasks.UpdateTaskStatusDto;
import com.tasks.tasks.dto.users.FindUserDto;
import com.tasks.tasks.dto.users.UpdateUserDto;
import com.tasks.tasks.exceptions.ResourceNotFoundException;
import com.tasks.tasks.model.User;
import com.tasks.tasks.repository.TaskRepository;
import com.tasks.tasks.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Override
    public String createTask(CreateTaskDto createTaskDto) {

        return "";
    }

    @Override
    public FindTagsResDto findTask(Long tagId) {
        return null;
    }

    @Override
    public List<FindTagsResDto> findTasks(int page, int pageSize) {
        return List.of();
    }

    @Override
    public String updateTaskStatus(UpdateTaskStatusDto updateTaskStatusDto, Long taskId) {
        return "";
    }

    @Override
    public String updateTask(CreateTaskDto createTaskDto, Long taskId) {
        return "";
    }

    @Override
    public String deleteTask(Long taskId) {
        return "";
    }
}
