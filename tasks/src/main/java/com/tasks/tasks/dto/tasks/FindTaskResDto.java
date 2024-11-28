package com.tasks.tasks.dto.tasks;

import com.tasks.tasks.Enums.TaskStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * projection for fetching a task
 */

public interface FindTaskResDto {
    String getId();
    String getTitle();
    String getDescription();
    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
    TaskStatus getStatus();
    List<String> getTags();
}
