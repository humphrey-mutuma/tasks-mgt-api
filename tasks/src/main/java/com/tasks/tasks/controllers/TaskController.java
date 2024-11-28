package com.tasks.tasks.controllers;


import com.tasks.tasks.Enums.TaskStatus;
import com.tasks.tasks.auth.model.UserPrincipal;
import com.tasks.tasks.dto.tasks.CreateTaskDto;
import com.tasks.tasks.dto.tasks.FindTaskResDto;
import com.tasks.tasks.dto.tasks.UpdateTaskStatusDto;
import com.tasks.tasks.model.Task;
import com.tasks.tasks.services.tasks.TaskService;
import com.tasks.tasks.shared.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/tasks")
public class TaskController  {
    private final TaskService taskService;

    /**
     * create a task with optional tags (if tags already exist, they are linked else created and linked
     * @param userDetails in session user
     * @param createTaskDto dto to create a user
     * @return success or fail message
     */
    @Operation(summary = "create a task with optional tags (if tags already exist, they are linked else created and linked)", description = "")
    @PostMapping()
    public ResponseEntity<ApiResponse<String>> createTask(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody  CreateTaskDto createTaskDto
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(
                        taskService.createTask(createTaskDto ,userDetails.getUsername()),
                        null));
    }

    /**
     * fetch the logged in user tasks with optional status and tags filters
     * @param userPrincipal in session user details
     * @param status optional status filter
     * @param tagName optional tagname filater
     * @param page the page to fetch
     * @param pageSize the number of items in this page
     * @return list of tasks by a user
     */
    @Operation(summary = "fetch the logged in user tasks with optional status and tags filters", description = "")
    @GetMapping()
    public ResponseEntity<ApiResponse<List<FindTaskResDto>>> findUserTasks(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @RequestParam(required = false) TaskStatus status,
            @RequestParam(required = false) String tagName,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
       List<FindTaskResDto> tasks = taskService.findUserTasks( status, tagName, page, pageSize ,userPrincipal.getId());
        if (tasks.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>("No tasks found", null));
        }
        return ResponseEntity.ok(new ApiResponse<>(tasks.size() + " Tasks found", tasks));

    }

    /**
     * Update task status
     * @param userPrincipal in session user details
     * @param status optional status filter
      * @param taskId is of the task to update
     * @return
     */
    @Operation(summary = "Update task status", description = "")
    @PatchMapping("/status/{taskId}")
    public ResponseEntity<ApiResponse<List<Task>>> updateTaskStatus(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @RequestParam(required = false) TaskStatus status,
            @PathVariable Long taskId
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(
                        taskService.updateTaskStatus(status, taskId ,userPrincipal.getId()), null));
    }

    /**
     * Update a tasks title, desc, status, and tags
     * @param userPrincipal
     * @param updateTaskDto
     * @param taskId
     * @return
     */
    @Operation(summary = "Update a tasks title, desc, status, and tags ", description = "")
    @PatchMapping("/{taskId}")
    public ResponseEntity<ApiResponse<String>> updateTask(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @RequestBody() CreateTaskDto updateTaskDto,
            @PathVariable("taskId") Long taskId
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(
                        taskService.updateTask(updateTaskDto, taskId ,userPrincipal.getId()), null));
    }

    /**
     * Delete a task by its id
     * @param userPrincipal is session user details
     * @param taskId to delete task id
     * @return success or fail message
     */

    @Operation(summary = "Delete a task by id ", description = "")
    @DeleteMapping("/{taskId}")
    public ResponseEntity<ApiResponse<String>> deleteTask(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @PathVariable("taskId") Long taskId
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(
                        taskService.deleteTask(taskId ,userPrincipal.getId()), null));
    }
}
