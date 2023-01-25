package com.retailer.payment.repository;

import com.retailer.payment.dto.PaymentResponse;
import com.retailer.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
//    Payment getByPaymentTransactionIdIgnoreCase(String paymentTransactionId);
//    List<Payment> findAllByPaymentStatusIgnoreCase(Boolean status);

    Payment findByOrderId(Integer orderId);

    Payment findByOrderIdAndPaymentStatus(Integer orderId, String status);
}
