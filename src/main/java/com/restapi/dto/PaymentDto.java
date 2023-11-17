package com.restapi.dto;

import com.restapi.model.Payment;
import com.restapi.request.PaymentRequest;
import org.springframework.stereotype.Component;

@Component
public class PaymentDto {
    public Payment mapToPayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setId(payment.getId());
        payment.setAmount(paymentRequest.getAmount());
        payment.setPaymentMethod(paymentRequest.getPaymentMethod());

        return payment;
    }
}
