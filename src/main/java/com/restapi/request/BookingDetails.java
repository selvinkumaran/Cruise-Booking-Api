package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetails {
    private String cruiseName;
    private String bookingStatus;
    private String bookingDate;
    private String destination;
    private String paymentDate;
    private String checkInDate;
    private String checkOutDate;
    private String amount;

}