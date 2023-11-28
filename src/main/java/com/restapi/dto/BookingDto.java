package com.restapi.dto;

import com.restapi.model.Booking;
import com.restapi.response.BookingResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingDto {

    public List<BookingResponse> mapToBookingResponse(List<Booking> bookingList) {
        List<BookingResponse> bookingResponseList = new ArrayList<>();

        for (Booking booking : bookingList) {
            BookingResponse bookingResponse = new BookingResponse();
            if (booking != null) {
                bookingResponse.setId(booking.getId());
                bookingResponse.setBookingDate(String.valueOf(booking.getBookingDate()));
            }


            // Check if AppUser and Tour are not null before accessing their properties
            if (booking.getAppUser() != null) {
                bookingResponse.setUserId(booking.getAppUser().getId());
                bookingResponse.setName(booking.getAppUser().getName());
                bookingResponse.setUsername(booking.getAppUser().getUsername());
            }

            if (booking.getBookingStatus() != null) {
                bookingResponse.setBookingStatus(booking.getBookingStatus().getStatus());
            }

            if (booking.getTour() != null) {
                bookingResponse.setDestination(booking.getTour().getDestination());

                // Check if Cruise is not null before accessing its properties
                if (booking.getTour().getCruise() != null) {
                    bookingResponse.setCruiseName(booking.getTour().getCruise().getName());
                }

                bookingResponse.setCheckInDate(booking.getTour().getCheckInDate());
                bookingResponse.setCheckOutDate(booking.getTour().getCheckOutDate());
            }

            if (booking.getPayment() != null) {
                bookingResponse.setPaymentDate(String.valueOf(booking.getPayment().getPaymentDate()));
                bookingResponse.setAmount(String.valueOf(booking.getPayment().getAmount()));
            }

            bookingResponseList.add(bookingResponse);
        }
        return bookingResponseList;
    }
}
