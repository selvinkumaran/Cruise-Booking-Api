package com.restapi.dto;

import com.restapi.model.AppUser;
import com.restapi.request.UserRequest;
import com.restapi.response.AuthResponse;
import com.restapi.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDto {

    public AuthResponse mapToAuthResponse(AppUser appUser) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setId(appUser.getId());
        authResponse.setName(appUser.getName());
        authResponse.setUsername(appUser.getUsername());
        authResponse.setRole(appUser.getRoles().getName());
        return authResponse;
    }
}
