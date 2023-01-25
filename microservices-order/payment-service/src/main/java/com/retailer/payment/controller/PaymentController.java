package com.retailer.payment.controller;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;
import com.retailer.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @GetMapping("/test-server")
    @ResponseStatus(HttpStatus.OK)
    public String testServer(){
        return "paymentService is up now";
    }
    @PostMapping("/pay")
    public Payment doPayment(@RequestBody Payment payment){
        System.err.println("viva order API get payment object"+ payment.getPaymentStatus()+","+payment.getOrderAmount());
        log.info("viva order API get payment object", payment.getPaymentStatus(),payment.getOrderAmount());
        return paymentService.doPayment(payment);
    }
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> allPaymentTransaction(){
        return paymentService.getAllPayments();
    }
    @GetMapping("/orderId={id}&status={message}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PaymentResponse getOrderPaymentStatus(@PathVariable(value = "id") Integer orderId,
                                                 @PathVariable(value = "message") Boolean status){
        System.err.println("REST CALL orderId:" + orderId + "&" + "status: " + status);
        return paymentService.filterByOrderPaymentStatus(orderId,status);
    }
}