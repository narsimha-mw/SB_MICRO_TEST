package com.retailer.payment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "PAYMENT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payment  implements Serializable {
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
