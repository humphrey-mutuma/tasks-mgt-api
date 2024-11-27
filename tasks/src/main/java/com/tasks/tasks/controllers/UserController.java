package com.tasks.tasks.controllers;

import com.tasks.tasks.dto.users.FindUserProfileDto;
import com.tasks.tasks.services.users.UserService;
import com.tasks.tasks.shared.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/users")
public class UserController {
    private final UserService userService;

    //     fetch user profile ***********************
    @GetMapping("/profile/{username}")
    public ResponseEntity<ApiResponse<FindUserProfileDto>> findUserProfile(
             @PathVariable("username") String username
    ) {

        return ResponseEntity
                .ok(new ApiResponse<>("Fetch user profile Successful", userService.findUserProfile(username)));
    }

//    // update user profile **************************
//    @PatchMapping()
//    public ResponseEntity<ApiResponse<?>> updateUserProfile(
//            @AuthenticationPrincipal UserDetails userDetails,
//            @RequestBody() UpdateUserDto updateUserProfileDto
//    ) {
//        return ResponseEntity
//                .ok(new ApiResponse<>(userService.updateUserProfile(userDetails.getUsername(), updateUserProfileDto), null));
//    }


//    // delete user *******************
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<ApiResponse<?>> deleteUser(
//            @AuthenticationPrincipal UserPrincipal userPrincipal,
//            @PathVariable("userId") Long userId
//    )  {
//        return ResponseEntity
//                .ok(new ApiResponse<>( userService.deleteUser(userPrincipal.getId()), null));
//    }


}
