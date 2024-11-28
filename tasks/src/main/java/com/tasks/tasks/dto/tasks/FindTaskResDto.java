package com.tasks.tasks.dto.tasks;

import com.tasks.tasks.Enums.TaskStatus;

import java.util.List;

/**
 * DTO for creating a task
 */

public interface FindTaskResDto {
    String getId();
    String getTitle();
    String getDescription();
    TaskStatus getStatus();
    List<String> getTags();
 }
