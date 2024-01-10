package com.restapi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    @PositiveOrZero(message = "Id should be a positive number or zero")
    private Long id;

    @PositiveOrZero(message = "Id should be a positive number or zero")
    @NotNull(message = "Amount cannot be null")
    private Double amount;

    @PositiveOrZero(message = "Id should be a positive number or zero")
    @NotNull(message = "ID cannot be null")
    private Long userId;

    @NotBlank(message = "CardHolder Name cannot be blank")
    @Size(min = 2, max = 255, message = "CardHolder Name should be between 2 and 255 characters")
    private String cardHolderName;

    @Pattern(regexp = "\\d{16}", message = "Card number should be a 16-digit number")
    private String cardNumber;

    @Pattern(regexp = "\\d{2}/\\d{2}", message = "Expiry date should be in MM/YY format")
    private String expiryDate;

    @Size(min = 3, max = 3, message = "CVC should be a 3-digit number")
    private String cvc;

}
