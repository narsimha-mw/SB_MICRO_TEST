package com.retailer.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.retailer.order.common.Payment;
import com.retailer.order.model.ProductOrder;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderPaymentTransactionResponse implements Serializable {
    private ProductOrder productOrder;
    private Payment payment;
    private String message;
private List<Payment> paymentList;
}
