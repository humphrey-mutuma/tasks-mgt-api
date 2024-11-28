package com.tasks.tasks.controllers;


import com.tasks.tasks.auth.model.UserPrincipal;
import com.tasks.tasks.dto.tasks.CreateTaskDto;
import com.tasks.tasks.dto.tasks.FindTaskResDto;
import com.tasks.tasks.dto.tasks.UpdateTaskStatusDto;
import com.tasks.tasks.model.Task;
import com.tasks.tasks.services.tasks.TaskService;
import com.tasks.tasks.shared.response.ApiResponse;
import lombok.RequiredArgsConstructor;
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


    @GetMapping()
    public ResponseEntity<ApiResponse<List<FindTaskResDto>>> findUserTasks(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("Fetch tasks Successful",
                        taskService.findUserTasks(page, pageSize ,userPrincipal.getId())));
    }

    @PatchMapping("/status/{taskId}")
    public ResponseEntity<ApiResponse<List<Task>>> updateTaskStatus(
            @AuthenticationPrincipal UserPrincipal userPrincipal,
            @RequestBody() UpdateTaskStatusDto updateTaskStatusDto,
            @PathVariable Long taskId
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(
                        taskService.updateTaskStatus(updateTaskStatusDto,taskId ,userPrincipal.getId()), null));
    }

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
