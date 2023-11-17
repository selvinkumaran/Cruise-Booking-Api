package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookingStatusRequest {

    @NotNull(message = "Booking ID cannot be null")
    private Long bookingId;

    @NotNull(message = "Booking Status ID cannot be null")
    private Long bookingStatusId;
}
