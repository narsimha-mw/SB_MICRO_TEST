package com.retailer.order.common;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentClient {
    private Integer id;
    private Boolean paymentStatus;
    private String paymentTransactionId;
    private int orderId;
    private Double orderAmount;
//    private List<Object> dump;
}
