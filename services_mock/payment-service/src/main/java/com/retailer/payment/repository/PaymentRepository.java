package com.retailer.payment.repository;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    Payment getByPaymentTransactionId(String paymentTransactionId);

    List<Payment> findAllByPaymentStatus(String status);
}
