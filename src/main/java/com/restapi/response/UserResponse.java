package com.restapi.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserResponse {

    private Long id;

    private String username;

    private String name;

    private String role;

}
