package com.tasks.tasks.auth.controller;

import com.tasks.tasks.auth.dto.*;
import com.tasks.tasks.auth.service.AuthService;
import com.tasks.tasks.shared.response.ApiResponse;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This controller controls user authentication like login and registrations
 * more endpoints like token refresh, user verifications can be added later
 */
@RestController
@RequestMapping("${api.prefix}/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Endpoint to register a new user.
     * Accepts a RegisterDto payload and returns a success message.
     *
     * @param registerDto the registration details of the new user
     * @return ResponseEntity containing a success message
     */

     @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> authenticateUser(
            @RequestBody RegisterDto registerDto
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Successfully registered", authService.register(registerDto)));
    }

    /**
     * Endpoint to login a user.
     * Accepts a LoginDto payload and returns a LoginResDto with authentication details.
     *
     * @param loginDto the login credentials of the user
     * @return ResponseEntity containing the login response
     */

     @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResDto>> login(@RequestBody LoginDto loginDto) {
             return ResponseEntity
                     .ok(new ApiResponse<>("Successfully logged in", authService.login(loginDto)));
    }

}
