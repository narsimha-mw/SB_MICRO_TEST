package com.retailer.place.order.service;

import com.retailer.place.order.common.Payment;
import com.retailer.place.order.dto.OrderResponse;
import com.retailer.place.order.dto.OrderPaymentTransactionRequest;
import com.retailer.place.order.dto.OrderPaymentTransactionResponse;
import com.retailer.place.order.model.Order;
import com.retailer.place.order.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements  OrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EntityManager entityManager;
    private OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public OrderPaymentTransactionResponse savedOrder(OrderPaymentTransactionRequest request){
        Order o= request.getOrder();
        System.err.println("request:="+o.getId()+";"+o.getOrderName()+";"+o.getQuantity()+";"+o.getPrice());

        String message = null;
        Order order = request.getOrder();
        orderRepository.save(order);
        Payment payment = request.getPayment();
//        payment.setOrderId(order.getId());
        payment.setOrderId(106);
        payment.setOrderAmount(order.getPrice());
   // call Payment APi using REST Template
        Payment responseAPI = restTemplate.postForObject("http://localhost:2001/api/v2/payment/pay",
                payment, Payment.class);
       System.err.println("responseAPI:="+responseAPI);
        if(responseAPI.getPaymentStatus().equals("success")) {
//            orderRepository.save(order);
            message = "This Order payment was successfully"+ order.getOrderName() + " and transactionId"+payment.getPaymentTransactionId();
        }else{
            message = "This Order payment was failure"+ order.getOrderName() + " and transactionId"+payment.getPaymentTransactionId();
        }
         return OrderPaymentTransactionResponse.builder()
                 .order(order)
                 .payment(responseAPI)
                 .message(message)
                 .build();
    }

    public Order saveOrder(Order request){
//        Order order = orderRepository.getLastRecordOfRow();
        System.err.println(request.getOrderName());
        return orderRepository.save(request);
         }

    public List<Order> fetchAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public OrderResponse getByOrderId(String orderId) {
        return null;
    }

    @Override
    public OrderResponse getByOrderName(String orderName) {
        List<Order> listOfOrderNames = orderRepository.findAllByOrderName(orderName);

        List<Order> placeOrders =  listOfOrderNames.stream()
                .map(this::placeOrderItems).collect(Collectors.toList());
       return OrderResponse.builder()
                        .orders(placeOrders)
                         .build();
    }

    private Order placeOrderItems(Order placeOrder) {
        return Order.builder()
                        .id(placeOrder.getId())
                        .orderName(placeOrder.getOrderName())
                        .price(placeOrder.getPrice())
                        .quantity(placeOrder.getQuantity())
                        .build();
    }

    public Order updateOrderBtId(Integer orderId, Order order){
        Optional<Order> orderIdExists = orderRepository.findById(orderId);
        if(orderIdExists.isPresent()) {
            Order placeOrder = orderRepository.findById(orderId).get();
            System.err.println("placeOrder"+placeOrder);
            placeOrder.setOrderName(order.getOrderName());
            placeOrder.setPrice(order.getPrice());
            placeOrder.setQuantity(order.getQuantity());
            return orderRepository.save(placeOrder);
        }else{
            return null;
        }
    }

    @Override
    public String deleteByOrder(String orderName) {
        Order orderNames = orderRepository.findByOrderName(orderName);
        orderRepository.deleteById(orderNames.getId());
        return "THis Order is deleted successfully "+orderNames.getOrderName();

    }

    public void deleteByOrder(Integer orderId){
        orderRepository.deleteById(orderId);
    }
}
