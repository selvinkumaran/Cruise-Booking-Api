package com.restapi.request;

import com.restapi.model.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @PositiveOrZero(message = "Id should be a positive number or zero")
    private Long id;

    @NotNull(message = "Amount cannot be null")
    private Double amount;

    private Long userId;

    private String cardHolderName;
    private String cardNumber;
    private String expiryDate;
    private String cvc;

    private Long bookingId;
}
