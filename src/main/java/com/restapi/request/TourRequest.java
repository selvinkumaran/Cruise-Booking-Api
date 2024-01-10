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
public class TourRequest {

    @PositiveOrZero(message = "Id should be a positive number or zero")
    private Long id;

    @NotNull(message = "Cruise ID cannot be null")
    private Long cruiseId;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price should be greater than 0")
    private Double price;

    @NotNull(message = "Check-in date cannot be null")
    private String checkInDate;

    @NotNull(message = "Check-out date cannot be null")
    private String checkOutDate;

    @NotBlank(message = "Destination cannot be blank")
    @Size(max = 255, message = "Destination should not exceed 255 characters")
    private String destination;

    @Min(value = 0, message = "Balance should be at least 0")
    private int balance;

}
