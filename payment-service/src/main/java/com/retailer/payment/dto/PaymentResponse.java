package com.retailer.payment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.retailer.payment.model.Payment;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentResponse {
    private Integer id;
    private String paymentTransactionId;
    private String paymentStatus;
    private double totalAmount;
    private int orderId;
    private String transactionStatus;
    private List<Payment> allPaymentStatus;
}
