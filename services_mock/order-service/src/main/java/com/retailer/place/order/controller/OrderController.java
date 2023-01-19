package com.retailer.place.order.controller;

import com.retailer.place.order.dto.OrderResponse;
import com.retailer.place.order.dto.OrderPaymentTransactionRequest;
import com.retailer.place.order.dto.OrderPaymentTransactionResponse;
import com.retailer.place.order.model.Order;
import com.retailer.place.order.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    private  static  final  String FALL_BACK_ORDER_SERVICES= "orderService";
    @GetMapping("/test-server")
    @ResponseStatus(HttpStatus.OK)
    public String testServer(){
        return "orderService is up now today....";
    }

    @PostMapping("/save-order")
    @CircuitBreaker(name = FALL_BACK_ORDER_SERVICES,fallbackMethod = "callSaveOrderService")
    public OrderPaymentTransactionResponse saveOrder(@RequestBody OrderPaymentTransactionRequest request){
            return orderService.savedOrder(request);
    }

    public OrderPaymentTransactionResponse filterByOrderIdOrderService(Exception e){
        return  OrderPaymentTransactionResponse.builder().build();
    }

    public OrderPaymentTransactionResponse callSaveOrderService(Exception e){
        return  OrderPaymentTransactionResponse.builder().build();
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order){
        System.err.println("service save REST call...");

        return orderService.saveOrder(order);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> fetchAllOrders(){
       return orderService.fetchAllOrders();
    }

    @GetMapping("/name={name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OrderResponse orderByName(@PathVariable(value = "name") String orderName){
        return orderService.getByOrderName(orderName);
    }
@GetMapping("/orderId={id}&pay-status={message}")
public OrderPaymentTransactionResponse filterByOrderPaymentStatus(@PathVariable(value = "id") Integer orderId,
                                                                 @PathVariable(value = "message") String paymentStatus){
        return orderService.filterByOrderPaymentStatus(orderId, paymentStatus);
}
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
 public Order updateOrderBtId(@PathVariable(value = "id") Integer orderId, @RequestBody Order order){
       return orderService.updateOrderBtId(orderId, order);
 }
 @DeleteMapping("/name={name}")
 @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteByOrder(@PathVariable(value = "name") String orderName){
        return orderService.deleteByOrder(orderName);
    }
}
