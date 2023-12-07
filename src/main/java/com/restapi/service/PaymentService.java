package com.restapi.service;

import com.restapi.dto.PaymentDto;
import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.Payment;
import com.restapi.repository.BookingRepository;
import com.restapi.repository.PaymentRepository;
import com.restapi.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "id", id));
    }

    public List<Payment> create(PaymentRequest paymentRequest) {
        Payment payment = paymentDto.mapToPayment(paymentRequest);
        associateBooking(payment,paymentRequest.getUserId());
        paymentRepository.save(payment);
        return findAll();
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Transactional
    private void associateBooking(Payment payment,Long userId) {
        AppUser appUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("AppUser", "userId", userId));
        payment.setAppUser(appUser);
    }
    public Payment getLatestPayment() {
        return paymentRepository.findFirstByOrderByIdDesc()
                .orElseThrow();
    }

}

