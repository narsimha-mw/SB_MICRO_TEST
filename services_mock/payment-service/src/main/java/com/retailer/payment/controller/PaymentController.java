package com.retailer.payment.controller;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;
import com.retailer.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/payment")
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
        return paymentService.doPayment(payment);
    }
    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> allPaymentTransaction(){
        return paymentService.getAllPayments();
    }
    @GetMapping("/tnId={id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public PaymentResponse getPaymentTransaction(@PathVariable(value = "id") String paymentTransactionId){
        return paymentService.getByPaymentTnId(paymentTransactionId);
    }

}