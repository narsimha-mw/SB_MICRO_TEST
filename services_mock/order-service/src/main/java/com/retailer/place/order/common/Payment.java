package com.retailer.place.order.common;

import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    private Integer id;
    private String paymentStatus;
    private String paymentTransactionId;
    private int orderId;
    private Double orderAmount;
}
