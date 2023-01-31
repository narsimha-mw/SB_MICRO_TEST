package com.retailer.order.service;

import com.retailer.order.common.Payment;
import com.retailer.order.dto.OrderPaymentTransactionRequest;
import com.retailer.order.dto.OrderPaymentTransactionResponse;
import com.retailer.order.dto.OrdersRequest;
import com.retailer.order.model.ProductOrder;
import com.retailer.order.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RefreshScope
@Slf4j
public class OrdersServiceImpl implements  OrdersService {
    private static final String PAYMENT_BASE_URL = "http://PAYMENT-SERVICE/api/v2/payment/pay";
    @Autowired
    private OrdersRepository orderRepository;
    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    Payment responseAPI = null;
    String message = null;

    @Override
    public List<ProductOrder> fetchAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderPaymentTransactionResponse savedOrder(OrderPaymentTransactionRequest request) {
        ProductOrder order = request.getProductOrder();
        int orderNumber = ThreadLocalRandom.current().nextInt(100000, 1000000);
        order.setOrderNumber(orderNumber);
        order.setPaymentStatus(false);
        orderRepository.save(order);
        ProductOrder lastRowOrder = orderRepository.findTopByOrderByIdDesc();
        log.info("lastRowOrder=", lastRowOrder.getId() + " product name: " + lastRowOrder.getProductName());

        if (lastRowOrder != null) {
            Payment payment = request.getPayment();
            payment.setOrderId(order.getOrderNumber());
            payment.setOrderAmount(lastRowOrder.getPrice());
            payment.setPaymentStatus(order.getPaymentStatus());
            // call Payment APi using REST Template
            Payment responseAPI = restTemplate.postForObject(PAYMENT_BASE_URL,
                    payment, Payment.class);
            if (!responseAPI.getPaymentStatus()) {
                message = "This Order placed and no payment" + responseAPI.getOrderId() + "and transactionId" + payment.getPaymentTransactionId();
            } else {
                message = "This Order payment was success" + responseAPI.getOrderId() + " and transactionId" + payment.getPaymentTransactionId();
            }
            return OrderPaymentTransactionResponse.builder()
                    .productOrder(order)
                    .payment(responseAPI)
                    .message(message)
                    .build();
        }
        return null;
    }

    @Override
    public OrderPaymentTransactionResponse filterByOrderPaymentStatus(Integer orderId, Boolean paymentStatus){
        Optional<ProductOrder> po = getFindByOrderId(orderId);
        if (po.isPresent()) {
            ProductOrder order = po.get();
            System.err.println("order "+ order);
            order.setOrderNumber(order.getOrderNumber());
            order.setPrice(order.getPrice());
            order.setQuantity(order.getQuantity());
            order.setProductName(order.getProductName());
            order.setPaymentStatus(paymentStatus);
            orderRepository.save(order);
            return OrderPaymentTransactionResponse.builder().message("Order/payment status updates success")
                    .build();
        }
        return OrderPaymentTransactionResponse.builder().message("Order Payment status updated").build();
    }
    private Optional<ProductOrder> getFindByOrderId(Integer orderId) {
        return orderRepository.findByOrderNumber(orderId);
    }
}
