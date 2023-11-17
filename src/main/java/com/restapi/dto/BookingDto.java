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
            bookingResponse.setId(booking.getId());
            bookingResponse.setUserId(booking.getAppUser().getId());
            bookingResponse.setName(booking.getAppUser().getName());
            bookingResponse.setUsername(booking.getAppUser().getUsername());
            bookingResponse.setBookingStatus(booking.getBookingStatus().getStatus());

            bookingResponseList.add(bookingResponse);
        }
        return bookingResponseList;
    }
}
