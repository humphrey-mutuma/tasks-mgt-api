package com.tasks.tasks.dto.tags;

/**
 * DTO for creating a task
 */

public interface FindTagsWithTasksCountResDto {
    String getId();
    String getTagname();
    Integer getTasksCount();
  }
