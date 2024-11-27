package com.tasks.tasks.dto.tags;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

/**
 * DTO for creating a tag
 */
@Data
public class CreateTagDto {
    @NotBlank
    private String tagname;
}
