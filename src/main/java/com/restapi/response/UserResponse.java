package com.restapi.response;

import com.restapi.request.UserRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class UserResponse {
    private Long id;
    private String username;
    private String name;
    private String role;}
