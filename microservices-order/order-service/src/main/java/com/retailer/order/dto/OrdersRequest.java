package com.retailer.order.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersRequest {
    private String orderNumber;
    private int quantity;
    private double price;
}
