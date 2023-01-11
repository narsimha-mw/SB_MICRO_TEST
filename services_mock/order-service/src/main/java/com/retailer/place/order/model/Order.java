package com.retailer.place.order.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "all_items")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "name")
    private String orderName;
    @Column(name = "qty")
    @NonNull
    private int quantity;
    private Double price;
}
