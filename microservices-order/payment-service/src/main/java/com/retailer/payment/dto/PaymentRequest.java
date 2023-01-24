package com.retailer.payment.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String orderNumber;
    private int quantity;
    private double price;
}
