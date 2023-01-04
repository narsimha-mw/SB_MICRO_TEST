package com.retailer.order.orderservice.services;

import com.retailer.order.orderservice.dto.order.OrderRequest;
import com.retailer.order.orderservice.dto.order.OrderResponse;

import java.util.List;

public interface OrderService {
    void placeTheOrder(OrderRequest orderRequest);

    List<OrderResponse> fetchAllOrders(OrderResponse orderResponse);
}
