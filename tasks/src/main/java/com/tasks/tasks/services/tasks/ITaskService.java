package com.tasks.tasks.services.tasks;

import com.tasks.tasks.Enums.TaskStatus;
import com.tasks.tasks.dto.tasks.CreateTaskDto;
import com.tasks.tasks.dto.tasks.FindTaskResDto;
import com.tasks.tasks.dto.tasks.UpdateTaskStatusDto;
import com.tasks.tasks.model.Task;

import java.util.List;

public interface ITaskService {


    String  createTask(CreateTaskDto createTaskDto, String username);

    List<FindTaskResDto> findUserTasks(TaskStatus status, String tagName, int page, int pageSize, Long userId);

    String updateTaskStatus(TaskStatus status, Long taskId, Long userId  );

    String updateTask(CreateTaskDto updateTaskDto, Long taskId , Long userId );

    String deleteTask(Long taskId, Long userId);
}
