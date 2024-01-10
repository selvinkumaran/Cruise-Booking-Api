package com.restapi.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class LoginRequest {

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 255, message = "Name should be between 2 and 255 characters")
    private String username;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;

}
