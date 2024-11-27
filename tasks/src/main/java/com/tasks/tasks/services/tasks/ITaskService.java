package com.tasks.tasks.services.tasks;

import com.tasks.tasks.dto.tags.FindTagsResDto;
import com.tasks.tasks.dto.tasks.CreateTaskDto;
import com.tasks.tasks.dto.tasks.UpdateTaskStatusDto;
import com.tasks.tasks.dto.users.FindUserDto;
import com.tasks.tasks.dto.users.UpdateUserDto;

import java.util.List;

public interface ITaskService {


    String  createTask(CreateTaskDto createTaskDto);

    FindTagsResDto findTask(Long tagId);

    List<FindTagsResDto> findTasks( int page, int pageSize);

    String updateTaskStatus(UpdateTaskStatusDto updateTaskStatusDto, Long taskId);

    String updateTask(CreateTaskDto createTaskDto, Long taskId    );

    String deleteTask(Long taskId);
}
