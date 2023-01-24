package com.retailer.order.service;

import com.retailer.order.common.Payment;
import com.retailer.order.common.PaymentStatus;
import com.retailer.order.dto.OrderPaymentTransactionRequest;
import com.retailer.order.dto.OrderPaymentTransactionResponse;
import com.retailer.order.model.ProductOrder;
import com.retailer.order.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RefreshScope
public class OrdersServiceImpl implements  OrdersService{
    private static final String PAYMENT_BASE_URL = "http://PAYMENT-SERVICE/api/v2/payment/pay";
    @Autowired
    private OrdersRepository orderRepository;
    @Autowired
    @Lazy
    private RestTemplate restTemplate;
    Payment responseAPI =null;
    String message = null;
//    private final String UNPAID= "unPaid";
//    @Override
//    public OrderPaymentTransactionResponse saveOrder(OrderPaymentTransactionRequest request) {
//        ProductOrder o= request.getProductOrder();
//        ProductOrder order = request.getProductOrder();
//        ProductOrder ord = orderRepository.save(order);
//        if(ord.getId()!=null){
//            System.err.println("ord= "+ord);
//        }else{
//            System.err.println("ord is null= "+ord);
//
//        }
//        ProductOrder lastRowOrder = orderRepository.findTopByOrderByIdDesc();
//        System.err.println("lastRowOrder="+ lastRowOrder.getId()+";"+lastRowOrder.getProductName());
//        if(lastRowOrder!=null) {
//            Payment payment = request.getPayment();
//            payment.setOrderId(lastRowOrder.getId());
//            payment.setOrderAmount(lastRowOrder.getPrice());
//            // call Payment APi using REST Template
//            responseAPI = restTemplate.postForObject(PAYMENT_BASE_URL,
//                    payment, Payment.class);
//            assert responseAPI != null;
//            if (responseAPI.getPaymentStatus().equals("success")) {
////            orderRepository.save(order);
//                message = "This Order payment was successfully" + order.getProductName() + " and transactionId" + payment.getPaymentTransactionId();
//            } else {
//                message = "This Order payment was failure" + order.getProductName() + " and transactionId" + payment.getPaymentTransactionId();
//            }
//            return OrderPaymentTransactionResponse.builder()
//                    .productOrder(order)
//                    .payment(responseAPI)
//                    .message(message)
//                    .build();
//        }
//        return null;
//    }

    @Override
    public List<ProductOrder> fetchAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderPaymentTransactionResponse savedOrder(OrderPaymentTransactionRequest request) {
        ProductOrder o= request.getProductOrder();
        ProductOrder order = request.getProductOrder();
        int orderNumber = ThreadLocalRandom.current().nextInt(100000, 1000000);
        order.setOrderNumber((long) orderNumber);
        order.setPaymentStatus(PaymentStatus.UNPAID);
        ProductOrder ord = orderRepository.save(order);
        if(ord.getId()!=null){
            System.err.println("ord= "+ord);
        }else{
            System.err.println("ord is null= "+ord);

        }
        ProductOrder lastRowOrder = orderRepository.findTopByOrderByIdDesc();
        System.err.println("lastRowOrder="+ lastRowOrder.getId()+";"+lastRowOrder.getProductName());
        if(lastRowOrder!=null) {
            Payment payment = request.getPayment();
            payment.setOrderId(lastRowOrder.getId());
            payment.setOrderAmount(lastRowOrder.getPrice());
            // call Payment APi using REST Template
            responseAPI = restTemplate.postForObject(PAYMENT_BASE_URL,
                    payment, Payment.class);
            assert responseAPI != null;
            if (responseAPI.getPaymentStatus().equals("success")) {
//            orderRepository.save(order);
                message = "This Order payment was successfully" + order.getProductName() + " and transactionId" + payment.getPaymentTransactionId();
            } else {
                message = "This Order payment was failure" + order.getProductName() + " and transactionId" + payment.getPaymentTransactionId();
            }
            return OrderPaymentTransactionResponse.builder()
                    .productOrder(order)
                    .payment(responseAPI)
                    .message(message)
                    .build();
        }
        return null;
    }

//    @Override
//    public OrdersResponse getByOrderId(String orderId) {
//        return null;
//    }

//    @Override
//    public OrdersResponse getByOrderId(String orderId) {
//        return null;
//    }
}
