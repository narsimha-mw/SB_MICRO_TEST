package com.retailer.controller;

import com.retailer.dto.OrderRequest;
import com.retailer.dto.OrderResponse;
import com.retailer.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderServiceController {
    @Autowired
    OrderService orderService;
    @GetMapping("/order/test")
    public String show(){
        System.out.println("show order");
        return "this order service is up now..";
    }
    @PostMapping("/order/placed")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
       orderService.placeTheOrder(orderRequest);
       return  "Order Place success";
    }
}