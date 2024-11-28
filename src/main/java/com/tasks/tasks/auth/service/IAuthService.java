package com.tasks.tasks.auth.service;

import com.tasks.tasks.auth.dto.*;

public interface IAuthService {

    /**
     * Registers a new user with the provided registration details.
     * @param registerDto the registration details of the user
     * @return a success message indicating successful registration
     */
    String register(RegisterDto registerDto);

    /**
     * Authenticates a user with the provided login credentials.
     * @param loginDto the login credentials of the user
     * @return LoginResDto containing authentication details such as token
     */
    LoginResDto login(LoginDto loginDto);
}
