package com.retailer.payment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "pay_status")
    private String paymentStatus;
    @Column(name = "pay_tnsID")
    private String paymentTransactionId;
    @NonNull
    private int orderId;
    @Column(name = "total_amt")
    private Double orderAmount;
}
