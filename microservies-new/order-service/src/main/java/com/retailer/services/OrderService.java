package com.retailer.services;

import com.retailer.dto.OrderRequest;
import com.retailer.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    void placeTheOrder(OrderRequest orderRequest);

}
