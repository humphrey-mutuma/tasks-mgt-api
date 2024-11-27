package com.tasks.tasks.controllers;


import com.tasks.tasks.services.tasks.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/tasks")
public class TaskController {
    private final TaskService taskService;



}
