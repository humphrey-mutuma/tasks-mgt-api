package com.tasks.tasks.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResDto {

    private String accessToken;
    private String refreshToken;
    private Long id;
    private String username;

//    add other here
}
