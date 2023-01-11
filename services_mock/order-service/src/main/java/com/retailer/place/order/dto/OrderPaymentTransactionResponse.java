package com.retailer.place.order.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.retailer.place.order.common.Payment;
import com.retailer.place.order.model.Order;
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
    private Order order;
    private Payment payment;
    private String message;
private List<Payment> paymentList;
}
