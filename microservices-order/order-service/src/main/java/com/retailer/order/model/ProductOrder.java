package com.retailer.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_orders")
public class ProductOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "order_no")
//    @JsonIgnoreProperties
    private Long orderNumber;
    @Column(name = "name")
    private String productName;
    @Column(name = "qty")
    @NonNull
    private int quantity;
    private Double price;
    @Column(name="payment_status")
    private Enum paymentStatus;
}