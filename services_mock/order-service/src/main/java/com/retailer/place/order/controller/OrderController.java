package com.retailer.place.order.controller;

import com.retailer.place.order.dto.OrderResponse;
import com.retailer.place.order.model.PlaceOrder;
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
        return "orderService is up now";
    }

    @PostMapping("/save")
    public PlaceOrder saveOrder(@RequestBody PlaceOrder order){
       return orderService.saveOrder(order);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PlaceOrder> fetchAllOrders(){
       return orderService.fetchAllOrders();
    }
    @GetMapping("/name={name}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OrderResponse orderByName(@PathVariable(value = "name") String orderName){
        return orderService.getByOrderName(orderName);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
 public PlaceOrder updateOrderBtId(@PathVariable(value = "id") Integer orderId, @RequestBody PlaceOrder order){
       return orderService.updateOrderBtId(orderId, order);
 }
 @DeleteMapping("/{id}")
 @ResponseStatus(HttpStatus.OK)
    public void deleteByOrder(@PathVariable(value = "id") Integer orderId){
orderService.deleteByOrder(orderId);
    }
}
