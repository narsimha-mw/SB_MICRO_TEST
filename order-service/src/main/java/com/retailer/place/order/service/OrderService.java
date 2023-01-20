package com.retailer.place.order.service;

import com.retailer.place.order.dto.OrderResponse;
import com.retailer.place.order.dto.OrderPaymentTransactionRequest;
import com.retailer.place.order.dto.OrderPaymentTransactionResponse;
import com.retailer.place.order.model.Order;

import java.util.List;

public interface OrderService {
    Order saveOrder(Order request);

    List<Order> fetchAllOrders();
    OrderResponse getByOrderId(String orderId);

    Order updateOrderBtId(Integer orderId, Order order);
    String deleteByOrder(String orderId);

    OrderResponse getByOrderName(String orderName);

    OrderPaymentTransactionResponse savedOrder(OrderPaymentTransactionRequest request);

    OrderPaymentTransactionResponse filterByOrderPaymentStatus(Integer orderId, String paymentStatus);
}
