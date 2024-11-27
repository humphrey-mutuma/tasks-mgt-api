package com.tasks.tasks.services.tasks;

import com.tasks.tasks.dto.tasks.CreateTaskDto;
import com.tasks.tasks.dto.tasks.UpdateTaskStatusDto;
import com.tasks.tasks.model.Task;

import java.util.List;

public interface ITaskService {


    String  createTask(CreateTaskDto createTaskDto, String username);

    List<Task> findTasks(int page, int pageSize, Long userId);

    String updateTaskStatus(UpdateTaskStatusDto updateTaskStatusDto, Long taskId, Long userId  );

    String updateTask(CreateTaskDto updateTaskDto, Long taskId , Long userId );

    String deleteTask(Long taskId, Long userId);
}
