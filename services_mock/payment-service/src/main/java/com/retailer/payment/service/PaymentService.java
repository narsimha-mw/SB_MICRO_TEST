package com.retailer.payment.service;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment doPayment(Payment payment);

    List<Payment> getAllPayments();

    PaymentResponse getByPaymentTnId(String paymentTransactionId);

    PaymentResponse filterByPaymentTransactionStatus(String status);

    PaymentResponse filterByOrderPaymentStatus(Integer orderId, String status);
}
