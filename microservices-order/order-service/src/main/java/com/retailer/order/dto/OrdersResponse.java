package com.retailer.order.dto;

import com.retailer.order.model.ProductOrder;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersResponse {
    private List<ProductOrder> productOrder;
}
