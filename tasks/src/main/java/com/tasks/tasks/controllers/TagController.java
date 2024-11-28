package com.tasks.tasks.controllers;


import com.tasks.tasks.dto.tags.FindTagsWithTasksCountResDto;
import com.tasks.tasks.dto.tags.FindTagWithTasksResDto;
import com.tasks.tasks.services.tags.TagService;
import com.tasks.tasks.shared.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/tags")
public class TagController {
    private final TagService tagService;

    /**
     * fetch a tag with its associated tasks
     * @param tagId id of tag to fetch
     * @return tags with associated tasks
     */
    @Operation(summary = "fetch a tag with its associated tasks", description = "")
    @GetMapping("/{tagId}")
    public ResponseEntity<ApiResponse<List<FindTagWithTasksResDto>>> findTagWithTasks(
            @PathVariable("tagId") Long tagId
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("Fetch tags with tasks Successful",
                        tagService.findTagWithTasks(tagId )));
    }

    /**
     * fetch all system tags with their associated tasks count
     * @return all system tags with their associated tasks count
     */
    @Operation(summary = "fetch all system tags with their associated tasks count", description = "")
    @GetMapping()
    public ResponseEntity<ApiResponse<List<FindTagsWithTasksCountResDto>>> findTagsWithTasksCount(
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("Fetch tags with tasks count Successful",
                        tagService.findTagsWithTasksCount(  )));
    }





}
