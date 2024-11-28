package com.tasks.tasks.controllers;

import com.tasks.tasks.auth.model.UserPrincipal;
import com.tasks.tasks.dto.users.FindUsersDto;
import com.tasks.tasks.model.User;
import com.tasks.tasks.services.users.UserService;
import com.tasks.tasks.shared.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {
    private final UserService userService;


    /**
     * fetch all system users
      * @return user details
     */
    @Operation(summary = "fetch all system users and their tasks and tasks count", description = "")
    @GetMapping()
    public ResponseEntity<ApiResponse<List<FindUsersDto>>> findUsers(
     ) {
        return ResponseEntity
                .ok(new ApiResponse<>("Fetch all users Successful",
                        userService.findUsers()));
    }

    /**
     * delete your account
     * @param userPrincipal in session user details
     * @return success or fail message
     */
    @Operation(summary = "Delete your account", description = "")
    @DeleteMapping()
    public ResponseEntity<ApiResponse<String>> deleteUser(
            @AuthenticationPrincipal UserPrincipal userPrincipal
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(
                        userService.deleteUser(userPrincipal.getId()), null));
    }

}
