package com.retailer.place.order.dto;

import com.retailer.place.order.model.Order;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    private List<Order> orders;
}
