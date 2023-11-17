package com.restapi.controller;

import com.restapi.model.Role;
import com.restapi.request.BookingRequest;
import com.restapi.response.BookingResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RolesAllowed(Role.USER)
public class BookingController {
    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/{userId}")
    public ResponseEntity<APIResponse> getUserBooking(@PathVariable Long userId) {
        List<BookingResponse> bookingResponseList = bookingService.getUsersBooking(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> booking(@Valid @RequestBody BookingRequest bookingRequest) {
        List<BookingResponse> bookingResponseList = bookingService
                .booking(bookingRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookingResponseList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
