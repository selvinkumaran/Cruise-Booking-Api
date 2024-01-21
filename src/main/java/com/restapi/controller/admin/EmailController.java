package com.restapi.controller.admin;

import com.restapi.request.BookingConfirmationRequest;
import com.restapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody BookingConfirmationRequest bookingConfirmationRequest) {
        String to = bookingConfirmationRequest.getEmail();
        String subject = "Cruise Booking Confirmation";
        String body = "Dear Passenger,\n\n"
                + "We are pleased to inform you that your booking for the cruise \"" + bookingConfirmationRequest.getBookingDetails().getCruiseName() + "\" is confirmed!\n\n"
                + "Booking Reference: " + bookingConfirmationRequest.getBookingDetails().getBookingStatus() + "\n"
                + "Booking Date: " + bookingConfirmationRequest.getBookingDetails().getBookingDate() + "\n"
                + "Destination: " + bookingConfirmationRequest.getBookingDetails().getDestination() + "\n"
                + "Payment Date: " + bookingConfirmationRequest.getBookingDetails().getPaymentDate() + "\n"
                + "Amount: " + bookingConfirmationRequest.getBookingDetails().getAmount() + "\n"
                + "CheckIn Date: " + bookingConfirmationRequest.getBookingDetails().getCheckInDate() + "\n"
                + "CheckOut Name: " + bookingConfirmationRequest.getBookingDetails().getCheckOutDate() + "\n\n"
                + "Thank you for choosing our cruise services. We look forward to providing you with a wonderful experience!\n\n"
                + "Best regards,\nCruise Booking Team";
        System.out.println(body);
        emailService.sendSimpleEmail(to, subject, body);

        return "Email sent successfully!";
    }
}
