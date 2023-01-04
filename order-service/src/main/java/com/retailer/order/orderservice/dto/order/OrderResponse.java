package com.retailer.order.orderservice.dto.order;

import com.retailer.order.orderservice.model.OrderLineItems;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {

    private  Integer id;
    private String orderNumber;
    private List<OrderLineItems> orderLineItemsList;
}