package com.retailer.order.dto;

import com.retailer.order.model.ProductOrder;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersRequest {
    private ProductOrder orderIdWithStaus;
}
