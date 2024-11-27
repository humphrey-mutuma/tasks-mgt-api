package com.tasks.tasks.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Projection for fetching a user by username
 */
@Data
@AllArgsConstructor
public class FindUserDto {
    private Long id;
    private String username;
}
