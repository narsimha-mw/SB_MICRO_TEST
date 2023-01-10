package com.retailer.place.order.service;

import com.retailer.place.order.dto.OrderResponse;
import com.retailer.place.order.model.PlaceOrder;

import java.util.List;

public interface OrderService {
    PlaceOrder saveOrder(PlaceOrder order);

    List<PlaceOrder> fetchAllOrders();
    OrderResponse getByOrderId(String orderId);

    PlaceOrder updateOrderBtId(Integer orderId, PlaceOrder order);
    void deleteByOrder(Integer orderId);

    OrderResponse getByOrderName(String orderName);
}
