package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CruiseRequest {


    @PositiveOrZero(message = "Id should be a positive number or zero")
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 2, max = 255, message = "Name should be between 2 and 255 characters")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = 1000, message = "Description should not exceed 1000 characters")
    private String description;

    @NotNull(message = "Photo cannot be null")
    private String photo;

    @Min(value = 0, message = "Capacity should not be less than 0")
    private int capacity;

}
