package com.tasks.tasks.dto.tasks;

import com.tasks.tasks.Enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

     @NotBlank
     @Schema(description = "Status of the task",
             example = "PENDING",
             allowableValues = {"PENDING", "IN_PROGRESS", "COMPLETED"})
     private TaskStatus status;

//    assumption is users can create comma separated custom tags on the fry when creating tasks
    private List<String> tags;
}
