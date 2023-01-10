package com.retailer.place.order.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="place_order")
public class PlaceOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String orderName;
    @Column(name = "qty")
    @NonNull
    private int quantity;
    private Double price;
}
