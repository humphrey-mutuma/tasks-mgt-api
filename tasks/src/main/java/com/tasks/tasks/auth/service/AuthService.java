package com.tasks.tasks.auth.service;

import com.tasks.tasks.auth.dto.*;
import com.tasks.tasks.auth.repo.AuthRepository;
import com.tasks.tasks.exceptions.UserAlreadyExistsException;
import com.tasks.tasks.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService{
    @Autowired
    AuthenticationManager authManager;
    private final JWTService jwtService;
    private final AuthRepository authRepository;
    /**
     * Hash & salt password
     */
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    /**
     * TODO:  add as an env variable.
     */
     long access_token_exp_time = 24 * 60 * 60 * 1000;  // 24 hours in milliseconds
    long refresh_token_exp_time = 14 * 24 * 60 * 60 * 1000;  // 24 hours in milliseconds

    /**
     * Registers a new user with the provided registration details.
     * @param registerDto the registration details of the user
     * @return a success message indicating successful registration
     */
    @Transactional
    @Override
    public String register(RegisterDto registerDto) {
   //   Check if the username already exists
          Optional<User> existingUser = authRepository.findByUsername(registerDto.getUsername());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("Username already exists!"); // custom exception
         }

        try {
   //    Create a new User

             User newUser = new User();
             newUser.setUsername(registerDto.getUsername());
             newUser.setPassword(encoder.encode(registerDto.getPassword())); // hash passwords

            authRepository.save(newUser);

            return "Successfully registered, please login";

            }catch (RuntimeException e) {
                // Return a response indicating invalid credentials
                throw  new RuntimeException( "Something went wrong, try again later or contact admin!");
            }


    }

    /**
     * Authenticates a user with the provided login credentials.
     * @param loginDto the login credentials of the user
     * @return LoginResDto containing authentication details such as token
     */
    @Transactional
    public LoginResDto login(LoginDto loginDto) {

        User existing_user = authRepository.findByUsername(loginDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("user not found, please register"));

       try {

           // Attempt authentication
           Authentication authentication = authManager.authenticate(
                   new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
           );

           // Check if authentication was successful
           if (!authentication.isAuthenticated()) {
               throw new BadCredentialsException("Invalid Credentials, please check your username or password!");
           }

           // Generate  tokens
           String accessToken = jwtService.generateToken(loginDto.getUsername(), access_token_exp_time);
           String refreshToken = jwtService.generateToken(loginDto.getUsername(), refresh_token_exp_time);

           // Return successful response with accessToken and user details
           return new LoginResDto(
                   accessToken,
                   refreshToken,
                   existing_user.getId(),
                   existing_user.getUsername());

       } catch (BadCredentialsException e) {
           // Return a response indicating invalid credentials
          throw  new BadCredentialsException( "Invalid credentials, please check your username or password!");
       }
   }



}
