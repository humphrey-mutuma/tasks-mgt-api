package com.tasks.tasks.dto.users;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * DTO for updating a users username
 */
@Data
public class UpdateUserDto {
    @NotBlank
    private String username;
    @NotBlank
    private String newUsername;
 }
