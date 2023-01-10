package com.retailer.payment.service;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment doPayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentStatus(String paymentStatus);

    PaymentResponse getByPaymentTnId(String paymentTransactionId);
}
