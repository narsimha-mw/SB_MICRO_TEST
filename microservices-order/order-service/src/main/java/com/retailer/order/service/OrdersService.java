package com.retailer.order.service;

import com.retailer.order.dto.OrderPaymentTransactionRequest;
import com.retailer.order.dto.OrderPaymentTransactionResponse;
import com.retailer.order.model.ProductOrder;

import java.util.List;

public interface OrdersService {
//    OrderPaymentTransactionResponse saveOrder(OrderPaymentTransactionRequest request);

    List<ProductOrder> fetchAllOrders();

    OrderPaymentTransactionResponse savedOrder(OrderPaymentTransactionRequest request);
//    OrdersResponse getByOrderId(String orderId);

}
