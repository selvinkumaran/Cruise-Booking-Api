package com.restapi.controller.admin;


import com.restapi.model.Payment;
import com.restapi.model.Role;
import com.restapi.response.common.APIResponse;
import com.restapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/payments")
@RolesAllowed(Role.ADMIN)
public class AdminPaymentController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private PaymentService paymentService;
    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllPayment() {
        List<Payment> paymentList = paymentService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(paymentList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
