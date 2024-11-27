package com.tasks.tasks.dto.tags;

/**
 * DTO for creating a task
 */

public interface FindTagsWithTasksResDto {
    String getId();
    String getTagname();
    String getTasks(); // this will be returned as a string, to be parsed on the client side
  }
