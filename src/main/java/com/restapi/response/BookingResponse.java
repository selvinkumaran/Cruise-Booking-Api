package com.restapi.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    private Long id;

    private Long userId;

    private String name;

    private String username;

    private String bookingStatus;

    private String bookingDate;

    private String CheckInDate;

    private String CheckOutDate;

    private String cruiseName;

    private String destination;

    private String paymentDate;

    private String amount;

}
