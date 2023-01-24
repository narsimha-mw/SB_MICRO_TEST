package com.retailer.order.dto;

import com.retailer.order.common.Payment;
import com.retailer.order.model.ProductOrder;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPaymentTransactionRequest {
    private ProductOrder productOrder;
    private Payment payment;
}
