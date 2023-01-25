package com.retailer.payment.service;

import com.retailer.payment.common.ProductOrder;
import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;
import com.retailer.payment.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    private static final String ORDER_BASE_URL = "http://ORDER-SERVICE/api/v2/order/orderId={id}&pay-status={message}";

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Payment doPayment(Payment payment) {
        System.err.println("viva doPayment payment service call"+ payment.getPaymentStatus()+""+payment.getOrderAmount());
        log.info("viva doPayment payment service call", payment.getPaymentStatus(),payment.getOrderAmount());
        int tnxId = ThreadLocalRandom.current().nextInt(100000, 1000000);
        payment.setPaymentTransactionId("TX" + tnxId);
        System.err.println("payment object"+ payment.getPaymentStatus());
        log.info("payment object", payment.getPaymentStatus());
        return paymentRepository.save(payment);
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
//this one valid
    @Override
    public PaymentResponse filterByOrderPaymentStatus(Integer orderId, Boolean paymentStatus) {
        Payment payment = paymentRepository.findByOrderId(orderId);
        System.err.println(payment + "orderId:" + orderId + "===" + "status: " + paymentStatus);
        if (payment != null) {
            payment.setPaymentStatus(paymentStatus);
            System.err.println(payment.getPaymentStatus());
            paymentRepository.save(payment);
            Integer id = orderId;
            // rest API orderService
            ProductOrder productOrder = restTemplate.getForObject(ORDER_BASE_URL,
              ProductOrder.class,id,paymentStatus );
            System.err.println(productOrder+ " productOrder "+productOrder.getMessage()
            +","+productOrder.getMessage());
            return PaymentResponse.builder()
                    .paymentStatusMsg(productOrder.getMessage())
                    .orderId(payment.getOrderId())
                    .paymentStatus(payment.getPaymentStatus())
                    .paymentTransactionId(payment.getPaymentTransactionId())
                    .totalAmount(payment.getOrderAmount())
                    .build();
        }
        return PaymentResponse.builder()
                .paymentStatusMsg("Payment was field...")
                .orderId(payment.getOrderId())
                .build();

    }
    private Payment mapToPaymentStatus(Payment payment) {
        return Payment.builder()
                .id(payment.getId())
                .paymentStatus(payment.getPaymentStatus())
                .paymentTransactionId(payment.getPaymentTransactionId())
                .orderAmount(payment.getOrderAmount())
                .orderId(payment.getOrderId())
                .build();
    }
}