package com.retailer.services;

import com.retailer.dto.order.OrderRequest;
import com.retailer.dto.order.OrderResponse;

import java.util.List;

public interface OrderService {
    void placeTheOrder(OrderRequest orderRequest);

    List<OrderResponse> fetchAllOrders(OrderResponse orderResponse);
}
