package com.retailer.payment.service;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;
import com.retailer.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements  PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public Payment doPayment(Payment payment) {
        String paymentStatus = new Random().nextBoolean() ? "success" : "failur";
        int tnxId = ThreadLocalRandom.current().nextInt(100000, 1000000);

        payment.setPaymentTransactionId("TX" + tnxId);
        payment.setPaymentStatus(paymentStatus);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }


    @Override
    public PaymentResponse getByPaymentTnId(String paymentTransactionId) {
        System.err.println("id=" + paymentTransactionId);
        Payment tnId = paymentRepository.getByPaymentTransactionIdIgnoreCase(paymentTransactionId);
        System.err.println("paymentTransactionId" + tnId);
        if (tnId != null) {
            return PaymentResponse.builder()
                    .id(tnId.getId())
                    .paymentStatus(tnId.getPaymentStatus())
                    .paymentTransactionId(tnId.getPaymentTransactionId())
                    .build();
        } else {
            return PaymentResponse.builder().paymentTransactionId(paymentTransactionId).transactionStatus("Invalid TnId").build();
        }
    }

    @Override
    public PaymentResponse filterByPaymentTransactionStatus(String status) {
       List <Payment> response = paymentRepository.findAllByPaymentStatusIgnoreCase(status);
       response.forEach(e->System.err.println(e.getPaymentStatus()));
        List<Payment> filterResponse = response.stream().map(this::mapToPaymentStatus).collect(Collectors.toList());
        return PaymentResponse.builder()
                .allPaymentStatus(filterResponse)
                .build();
    }

    @Override
    public PaymentResponse filterByOrderPaymentStatus(Integer orderId, String status) {
        Payment order_id = paymentRepository.findByOrderId(orderId);
        if(order_id!=null) {

        }
         Payment response = paymentRepository.findByOrderIdAndPaymentStatus(orderId, status);
         return PaymentResponse.builder()
                 .id(response.getId())
                 .totalAmount(response.getOrderAmount())
                 .orderId(response.getOrderId())
                 .transactionStatus(response.getPaymentStatus())
                 .paymentTransactionId(response.getPaymentTransactionId())
                 .build();
    }

    @Override
    public PaymentResponse filterByOrderPaymentStatusApplied(Integer orderId, String status) {
        Payment payment = paymentRepository.findByOrderId(orderId);
        if(orderId!=null){
            payment.setPaymentStatus(status);
            paymentRepository.save(payment);
        }
        return PaymentResponse.builder()
                        .paymentStatus("Payment successfully ")
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