package com.tasks.tasks.controllers;


import com.tasks.tasks.dto.tags.FindTagsWithTasksCountResDto;
import com.tasks.tasks.dto.tags.FindTagWithTasksResDto;
import com.tasks.tasks.services.tags.TagService;
import com.tasks.tasks.shared.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/tags")
public class TagController {
    private final TagService tagService;

    @GetMapping("/{tagId}")
    public ResponseEntity<ApiResponse<List<FindTagWithTasksResDto>>> findTagWithTasks(
            @PathVariable("tagId") Long tagId
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("Fetch tags with tasks Successful",
                        tagService.findTagWithTasks(tagId )));
    }


    @GetMapping()
    public ResponseEntity<ApiResponse<List<FindTagsWithTasksCountResDto>>> findTagsWithTasksCount(

    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("Fetch tags with tasks count Successful",
                        tagService.findTagsWithTasksCount(  )));
    }





}
