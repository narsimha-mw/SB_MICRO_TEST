package com.retailer.place.order.controller;

import com.retailer.place.order.dto.OrderResponse;
import com.retailer.place.order.dto.OrderPaymentTransactionRequest;
import com.retailer.place.order.dto.OrderPaymentTransactionResponse;
import com.retailer.place.order.model.Order;
import com.retailer.place.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("/test-server")
    @ResponseStatus(HttpStatus.OK)
    public String testServer(){
        return "orderService is up now today....";
    }

    @PostMapping("/save-order")
        public OrderPaymentTransactionResponse saveOrder(@RequestBody OrderPaymentTransactionRequest request){
            return orderService.savedOrder(request);
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
