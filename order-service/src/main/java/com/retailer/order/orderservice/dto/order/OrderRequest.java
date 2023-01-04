package com.retailer.order.orderservice.dto.order;

import com.retailer.order.orderservice.dto.orderlineitems.OrderLineItemRequest;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    private List<OrderLineItemRequest> orderLineItemRequestList;

}
