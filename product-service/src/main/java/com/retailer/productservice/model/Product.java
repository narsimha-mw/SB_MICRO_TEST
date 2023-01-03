package com.retailer.productservice.model;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
@Id
private Integer id;
private String name;
private  String description;
private BigDecimal price;
}
