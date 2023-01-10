package com.retailer.place.order.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private String orderNumber;
    private int quantity;
    private double price;
}
