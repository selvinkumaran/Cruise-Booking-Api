package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {
    @PositiveOrZero(message = "Id should be a positive number or zero")
    private Long id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 255, message = "Name should be between 2 and 255 characters")
    private String name;
    private String username;

}
