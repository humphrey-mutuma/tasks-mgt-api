package com.tasks.tasks.dto.tasks;

import com.tasks.tasks.Enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * DTO for creating a task
 */
@Data
public class UpdateTaskStatusDto {
    @NotBlank
    private TaskStatus status ;
}
