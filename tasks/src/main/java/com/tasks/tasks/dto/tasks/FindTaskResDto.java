package com.tasks.tasks.dto.tasks;

import com.tasks.tasks.Enums.TaskStatus;

/**
 * DTO for creating a task
 */

public interface FindTaskResDto {
    String getId();
    String getTitle();
    String getDescription();
    TaskStatus getStatus();
    String getTags(); //  returned as string, will be parsed to json on the client side
}
