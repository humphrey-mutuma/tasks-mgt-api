package com.tasks.tasks.dto.users;

/**
 * Projection for fetching a users profile by username
 */
public interface FindUserProfileDto {
    Long getId();
    String getUsername();
}
