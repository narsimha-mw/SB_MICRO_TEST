package com.retailer.payment.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "pay_status")
    private String paymentStatus;
    @Column(name = "pay_tnsID")
    @NonNull
    private String paymentTransactionId;
}
