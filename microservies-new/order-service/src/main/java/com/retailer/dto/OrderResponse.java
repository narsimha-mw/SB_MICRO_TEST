package com.retailer.dto;

import com.retailer.model.OrderLineItems;
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