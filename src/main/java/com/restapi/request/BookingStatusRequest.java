package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingStatusRequest {

    @NotNull(message = "Booking ID cannot be null")
    private Long bookingId;

    @NotNull(message = "Booking Status ID cannot be null")
    @Positive(message = "BookingStatus ID must be a positive number")
    private Long bookingStatusId;

}
