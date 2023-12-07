package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Payment ID cannot be null")
    @Positive(message = "Payment ID must be a positive number")
    private Long paymentId;

    @NotNull(message = "Tour ID cannot be null")
    @Positive(message = "Tour ID must be a positive number")
    private Long tourId;

}
