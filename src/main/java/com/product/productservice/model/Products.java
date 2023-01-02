package com.product.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Documented;
import java.math.BigDecimal;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Products {

    private String Id;
    private String name;
    private String description;
    private BigDecimal price;
}
