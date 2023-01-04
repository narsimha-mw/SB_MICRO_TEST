package com.retailer.dto;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItemRequest {

    private  String sku;
    private BigDecimal price;
    private Integer quantity;

}
