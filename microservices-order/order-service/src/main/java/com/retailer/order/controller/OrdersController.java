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
    @GetMapping("/test-server")
    @ResponseStatus(HttpStatus.OK)
    public String testServer(){
        return "orderService is up now today....";
    }
    int count=1;
    @PostMapping("/save-order")
    public OrderPaymentTransactionResponse saveOrder(@RequestBody OrderPaymentTransactionRequest request){
        System.out.println("Retry API flow"+ count++ + "time at "+ new Date());
        return orderService.savedOrder(request);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductOrder> fetchAllOrders(){
        return orderService.fetchAllOrders();
    }
    @GetMapping("/orderId={id}&pay-status={paymentStatus}")
    public OrderPaymentTransactionResponse filterByOrderPaymentStatus(@PathVariable(value = "id") Integer orderId,
                                                                      @PathVariable(value = "paymentStatus") Boolean paymentStatus){
        System.err.println(" order update status API call orderId:" + orderId + "status"+paymentStatus);
        return orderService.filterByOrderPaymentStatus(orderId, paymentStatus);
    }
}
