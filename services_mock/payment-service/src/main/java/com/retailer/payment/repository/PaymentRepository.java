package com.retailer.payment.repository;

import com.retailer.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment getByPaymentTransactionId(String paymentTransactionId);
}
