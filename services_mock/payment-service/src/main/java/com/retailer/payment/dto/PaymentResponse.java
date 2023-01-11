package com.retailer.payment.dto;

import com.retailer.payment.model.Payment;
import lombok.*;

import java.util.List;

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
    private List<Payment> allPaymentStatus;
}
