package com.tasks.tasks.controllers;


import com.tasks.tasks.services.tags.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/tags")
public class TagController {
    private final TagService tagService;




}
