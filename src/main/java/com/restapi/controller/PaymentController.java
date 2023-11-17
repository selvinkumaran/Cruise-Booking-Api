package com.restapi.controller;

import com.restapi.model.Payment;
import com.restapi.model.Role;
import com.restapi.request.PaymentRequest;
import com.restapi.response.common.APIResponse;
import com.restapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RolesAllowed(Role.USER)
public class PaymentController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{paymentId}")
    public ResponseEntity<APIResponse> getPaymentDetails(@PathVariable Long paymentId) {
        Payment payment = paymentService.findPaymentById(paymentId);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(payment);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<APIResponse> createPayment(@Valid @RequestBody PaymentRequest paymentRequest) {
        List<Payment> paymentList = paymentService.create(paymentRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(paymentList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
