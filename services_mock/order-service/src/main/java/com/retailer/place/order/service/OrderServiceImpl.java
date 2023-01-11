package com.retailer.place.order.service;

import com.retailer.place.order.common.Payment;
import com.retailer.place.order.dto.OrderResponse;
import com.retailer.place.order.dto.OrderPaymentTransactionRequest;
import com.retailer.place.order.dto.OrderPaymentTransactionResponse;
import com.retailer.place.order.model.Order;
import com.retailer.place.order.repository.OrderRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private static final String PAYMENT_BASE_URL = "http://localhost:2001/api/v2/payment";
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EntityManager entityManager;

    public OrderPaymentTransactionResponse savedOrder(OrderPaymentTransactionRequest request){
        Order o= request.getOrder();
        String message = null;
        Order order = request.getOrder();
        Order ord = orderRepository.save(order);
        if(ord.getId()!=null){
            System.err.println("ord= "+ord);
        }else{
            System.err.println("ord is null= "+ord);

        }
        Order lastRowOrder = orderRepository.findTopByOrderByIdDesc();
        System.err.println("lastRowOrder="+ lastRowOrder.getId()+";"+lastRowOrder.getOrderName());
        Payment responseAPI =null;
        if(lastRowOrder!=null) {
            Payment payment = request.getPayment();
        payment.setOrderId(lastRowOrder.getId());
            payment.setOrderAmount(lastRowOrder.getPrice());
            // call Payment APi using REST Template
            responseAPI = restTemplate.postForObject(PAYMENT_BASE_URL+"/pay",
                    payment, Payment.class);
            assert responseAPI != null;
            if (responseAPI.getPaymentStatus().equals("success")) {
//            orderRepository.save(order);
                message = "This Order payment was successfully" + order.getOrderName() + " and transactionId" + payment.getPaymentTransactionId();
            } else {
                message = "This Order payment was failure" + order.getOrderName() + " and transactionId" + payment.getPaymentTransactionId();
            }

            return OrderPaymentTransactionResponse.builder()
                    .order(order)
                    .payment(responseAPI)
                    .message(message)
                    .build();
        }
        return null;
    }
// match with orderId along with more than one paymentStatus response
    @Override
    public OrderPaymentTransactionResponse filterByOrderPaymentStatus(Integer orderId, String paymentStatus) {
        List<Payment> apiResponse = restTemplate.getForObject(PAYMENT_BASE_URL + "/orderId="
                        + orderId + "&status=" + paymentStatus, List.class);
        System.err.println("apiResponse: " + apiResponse.size());
        return OrderPaymentTransactionResponse.builder()
                .paymentList(apiResponse)
                .build();
    }
    public Order saveOrder(Order request){
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
//        Optional<Order> orderIdExists = orderRepository.findById(orderId);
        if(getFindByOrderId(orderId)) {
            Order placeOrder = orderRepository.findById(orderId).get();
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
        Order orderNames = orderRepository.findByOrderNameIgnoreCase(orderName);
        orderRepository.deleteById(orderNames.getId());
        return "THis Order is deleted successfully "+orderNames.getOrderName();
    }

    private Boolean getFindByOrderId(Integer orderId){
        Optional<Order> orderIdResponse = orderRepository.findById(orderId);
        return orderIdResponse.isPresent() ? true : false;
    }

}
