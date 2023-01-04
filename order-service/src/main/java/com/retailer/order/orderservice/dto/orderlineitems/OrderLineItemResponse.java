package com.retailer.order.orderservice.dto.orderlineitems;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderLineItemResponse {
    private Long id;
    private  String skuCode;
    private BigDecimal price;
    private Integer quantity;
}