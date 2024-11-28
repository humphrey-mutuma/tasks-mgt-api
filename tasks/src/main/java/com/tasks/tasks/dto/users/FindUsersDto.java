package com.tasks.tasks.dto.users;

/**
 * Dto for fetching system users
 */

public interface FindUsersDto {
    Long getId();
    String getUsername();
    String getTasks(); // returned as a string array
    String getTaskCount(); // returned as a string array
}
