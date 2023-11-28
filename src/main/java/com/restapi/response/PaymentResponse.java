package com.restapi.response;

import com.restapi.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PaymentResponse {

    List<Payment> paymentList;
}
