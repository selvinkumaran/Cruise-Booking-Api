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
public class FeedbackRequest {

    @PositiveOrZero(message = "Id should be a positive number or zero")
    private Long id;

    @Min(value = 1, message = "Rating should be at least 1")
    @Max(value = 5, message = "Rating should not exceed 5")
    private int rating;

    @NotBlank(message = "Comments cannot be blank")
    @Size(max = 255, message = "Comments should not exceed 255 characters")
    private String comments;

    private Long userId;

}
