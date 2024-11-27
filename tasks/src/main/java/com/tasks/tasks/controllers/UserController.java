package com.tasks.tasks.controllers;

import com.tasks.tasks.dto.users.FindUserDto;
import com.tasks.tasks.services.users.UserService;
import com.tasks.tasks.shared.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {
    private final UserService userService;


    /**
     * fetch the i session user
     * @param userDetails in session user details
     * @return user details
     */
    @GetMapping()
    public ResponseEntity<ApiResponse<FindUserDto>> findUser(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("Fetch user profile Successful",
                        userService.findUser(userDetails.getUsername())));
    }

}
