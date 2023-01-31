package com.retailer.order.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class ProductOrder implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "order_no")
    private Integer orderNumber;
    @Column(name = "name")
    private String productName;
    @Column(name = "qty")
    @NonNull
    private int quantity;
    private Double price;
    @Column(name="payment_status")
    private Boolean paymentStatus;
}