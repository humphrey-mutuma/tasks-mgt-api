package com.tasks.tasks.dto.tasks;

/**
 * DTO for creating a task
 */

public interface FindTaskResDto {
    String getId();
    String getTitle();
    String getDescription();
    Boolean getIsCompleted();
    String getTags(); //  returned as string, will be parsed to json on the client side
}
