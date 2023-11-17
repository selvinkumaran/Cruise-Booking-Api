package com.restapi.service;

import com.restapi.dto.BookingDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.Booking;
import com.restapi.model.BookingStatus;
import com.restapi.repository.BookingRepository;
import com.restapi.repository.BookingStatusRepository;
import com.restapi.repository.TourRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.BookingRequest;
import com.restapi.response.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingDto bookingDto;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingStatusRepository bookingStatusRepository;


    public List<BookingResponse> booking(BookingRequest bookingRequest) {
        AppUser appUser = userRepository.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", bookingRequest.getUserId()));

        BookingStatus bookingStatus = bookingStatusRepository.findById(1L)
                .orElseThrow(() ->
                        new ResourceNotFoundException("bookingStatusId", "bookingStatusId", 1));

        Booking booking = new Booking();
        booking.setAppUser(appUser);
        booking.setBookingStatus(bookingStatus);

        bookingRepository.save(booking);

        return getUsersBooking(bookingRequest.getUserId());
    }

    public List<BookingResponse> getUsersBooking(Long userId) {
        List<Booking> bookingList = bookingRepository.findUserBooking(userId)
                .orElseThrow(() -> new ResourceNotFoundException("userId", "userId", userId));
        return bookingDto.mapToBookingResponse(bookingList);
    }


    public List<BookingResponse> getAllBookings() {
        List<Booking> bookingList = bookingRepository.findAll();
        return bookingDto.mapToBookingResponse(bookingList);
    }

    public List<BookingStatus> getAllBookingStatus() {
        return bookingStatusRepository.findAll();
    }

    public List<BookingResponse> updateBookingStatus(Long bookingId, Long statusId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("bookingId", "bookingId", bookingId));

        BookingStatus bookingStatus = bookingStatusRepository.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException("statusId", "statusId", statusId));

        booking.setBookingStatus(bookingStatus);

        bookingRepository.save(booking);

        return getAllBookings();
    }
}
