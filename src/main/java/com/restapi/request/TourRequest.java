package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourRequest {

    @PositiveOrZero(message = "Id should be a positive number or zero")
    private Long id;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Cruise ID cannot be null")
    private Long cruiseId;

    @NotNull(message = "Price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price should be greater than 0")
    private Double price;

    @NotNull(message = "Check-in date cannot be null")
//    @FutureOrPresent(message = "Check-in date should be present or in the future")
//    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date should be in the format yyyy-MM-dd")
    private LocalDate checkInDate;

    @NotNull(message = "Check-out date cannot be null")
//    @Future(message = "Check-out date should be in the future")
//    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date should be in the format yyyy-MM-dd")
    private LocalDate checkOutDate;

    @NotBlank(message = "Destination cannot be blank")
    @Size(max = 255, message = "Destination should not exceed 255 characters")
    private String destination;

    @Min(value = 0, message = "Balance should be at least 0")
    private int balance;

}
