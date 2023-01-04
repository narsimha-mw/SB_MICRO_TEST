package com.retailer.order.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Integer id;
private String orderNumber;
@OneToMany(cascade = CascadeType.ALL)
private List<OrderLineItems> orderLineItemsList;
}
