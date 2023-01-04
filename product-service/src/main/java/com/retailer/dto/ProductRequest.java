package com.retailer.dto;

import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String name;
    private  String description;
    private String sku;
    private BigDecimal price;
}
