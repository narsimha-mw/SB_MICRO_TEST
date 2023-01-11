package com.retailer.place.order.dto;

import com.retailer.place.order.common.Payment;
import com.retailer.place.order.model.Order;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPaymentTransactionResponse {
    private Order order;
    private Payment payment;
    private String message;

}
