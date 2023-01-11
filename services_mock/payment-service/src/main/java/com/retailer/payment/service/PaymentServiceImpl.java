package com.retailer.payment.service;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;
import com.retailer.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements  PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

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
        Payment tnId = paymentRepository.getByPaymentTransactionId(paymentTransactionId);
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
       List <Payment> response = paymentRepository.findAllByPaymentStatus(status);
       response.forEach(e->System.err.println(e.getPaymentStatus()));
        List<Payment> filterResponse = response.stream().map(this::mapToPaymentStatus).collect(Collectors.toList());
        return PaymentResponse.builder()
                .allPaymentStatus(filterResponse)
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