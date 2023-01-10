package com.retailer.payment.service;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;
import com.retailer.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PaymentServiceImpl implements  PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment doPayment(Payment payment) {
        int tnxId = ThreadLocalRandom.current().nextInt(100000, 1000000);

        payment.setPaymentTransactionId("TX" + tnxId);
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentStatus(String paymentStatus) {
        return null;
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
}