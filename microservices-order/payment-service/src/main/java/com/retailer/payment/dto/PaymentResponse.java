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
    private String paymentTransactionId;
    private Boolean paymentStatus;
    private String paymentStatusMsg;
    private double totalAmount;
    private int orderId;
    
}
