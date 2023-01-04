package com.retailer.dto;


import lombok.*;

import java.math.BigDecimal;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private Integer id;
    private String name;
    private  String description;
    private String sku;
    private BigDecimal price;
}
