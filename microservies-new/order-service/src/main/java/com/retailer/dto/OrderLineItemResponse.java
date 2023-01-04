package com.retailer.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItemResponse {
    private Long id;
    private  String sku;
    private BigDecimal price;
    private Integer quantity;
}