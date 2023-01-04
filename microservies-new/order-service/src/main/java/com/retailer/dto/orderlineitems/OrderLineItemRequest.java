package com.retailer.dto.orderlineitems;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItemRequest {

    private  String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
