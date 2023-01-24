package com.retailer.order.controller;

import com.retailer.order.dto.OrderPaymentTransactionRequest;
import com.retailer.order.dto.OrderPaymentTransactionResponse;
import com.retailer.order.model.ProductOrder;
import com.retailer.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v2/order")
public class OrdersController {
    @Autowired
    private OrdersService orderService;
    private  static  final  String FALL_BACK_ORDER_SERVICES= "orderService";
    @GetMapping("/test-server")
    @ResponseStatus(HttpStatus.OK)
    public String testServer(){
        return "orderService is up now today....";
    }
    int count=1;
    @PostMapping("/save-order")
//    @CircuitBreaker(name = FALL_BACK_ORDER_SERVICES,fallbackMethod = "callSaveOrderService")
//    @Retry(name = FALL_BACK_ORDER_SERVICES,fallbackMethod = "callSaveOrderService")
//    @RateLimiter(name = FALL_BACK_ORDER_SERVICES,fallbackMethod = "callSaveOrderService") // wait until time next call
    public OrderPaymentTransactionResponse saveOrder(@RequestBody OrderPaymentTransactionRequest request){

        System.out.println("Retry API flow"+ count++ + "time at "+ new Date());
        return orderService.savedOrder(request);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductOrder> fetchAllOrders(){
        return orderService.fetchAllOrders();
    }

}
