package com.retailer.payment.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private Integer id;
    private String paymentTransactionId;
    private String paymentStatus;

    private String transactionStatus;
}
