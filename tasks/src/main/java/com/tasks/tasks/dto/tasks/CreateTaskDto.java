package com.tasks.tasks.dto.tasks;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * DTO for creating a task
 */
@Data
public class CreateTaskDto {
    @NotBlank
    private String title;

    private String description;

    private Boolean isCompleted = false;

//    assumption is users can create comma separated custom tags on the fry when creating tasks
    private List<String> tags;
}
