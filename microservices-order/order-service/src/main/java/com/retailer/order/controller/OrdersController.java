package com.retailer.order.controller;

import com.retailer.order.dto.OrderPaymentTransactionRequest;
import com.retailer.order.dto.OrderPaymentTransactionResponse;
import com.retailer.order.dto.OrdersRequest;
import com.retailer.order.dto.OrdersResponse;
import com.retailer.order.model.ProductOrder;
import com.retailer.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v2/order")
@Validated
public class OrdersController {
    @Autowired
    private OrdersService orderService;
    @GetMapping("/test-server")
    @ResponseStatus(HttpStatus.OK)
    public String testServer(){
        return "orderService is up now today....";
    }
    int count=1;
    @CrossOrigin
    @PostMapping(path="/save-order", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public OrderPaymentTransactionResponse saveOrder(@RequestBody OrderPaymentTransactionRequest request){
        System.out.println("Retry API flow"+ count++ + "time at "+ new Date());
        return orderService.savedOrder(request);
    }
    @CrossOrigin
    @GetMapping(path="/all", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public OrdersResponse fetchAllOrders(){
        List<ProductOrder> responses = orderService.fetchAllOrders();
        return OrdersResponse.builder().item(responses).build();
    }
    @CrossOrigin
    @GetMapping(path="/orderId={id}&pay-status={paymentStatus}", produces = "application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public OrderPaymentTransactionResponse filterByOrderPaymentStatus(@PathVariable(value = "id") Integer orderId,
                                                                      @PathVariable(value = "paymentStatus") Boolean paymentStatus) {
        return orderService.filterByOrderPaymentStatus(orderId, paymentStatus);
    }
}
