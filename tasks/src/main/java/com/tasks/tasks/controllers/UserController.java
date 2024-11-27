package com.tasks.tasks.controllers;

import com.tasks.tasks.dto.users.FindUserProfileDto;
import com.tasks.tasks.services.users.UserService;
import com.tasks.tasks.shared.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {
    private final UserService userService;

    //     fetch user profile ***********************
    @GetMapping("/{username}")
    public ResponseEntity<ApiResponse<FindUserProfileDto>> findUserProfile(
             @PathVariable("username") String username
    ) {

        return ResponseEntity
                .ok(new ApiResponse<>("Fetch user profile Successful", userService.findUserProfile(username)));
    }

}
