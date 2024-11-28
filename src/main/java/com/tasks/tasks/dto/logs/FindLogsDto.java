package com.tasks.tasks.dto.logs;

import java.time.LocalDateTime;

/**
 * Dto for fetching system users
 */

public interface FindLogsDto {
    Long getId();
    String getEntityName();  // Task or Tag
    Long getEntityId();
    String getAction();      // CREATED, UPDATED, DELETED
    String getDescription();
    LocalDateTime getTimestamp();
}
