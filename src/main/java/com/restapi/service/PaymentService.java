package com.restapi.service;

import com.restapi.dto.PaymentDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.Booking;
import com.restapi.model.Payment;
import com.restapi.repository.BookingRepository;
import com.restapi.repository.PaymentRepository;
import com.restapi.request.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentDto paymentDto;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "id", id));
    }

    public List<Payment> create(PaymentRequest paymentRequest) {
        Payment payment = paymentDto.mapToPayment(paymentRequest);
        associateBooking(payment, paymentRequest.getBookingId());
        paymentRepository.save(payment);
        return findAll();
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Transactional
    private void associateBooking(Payment payment, Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "bookingId", bookingId));
        payment.setBooking(booking);
    }
}

