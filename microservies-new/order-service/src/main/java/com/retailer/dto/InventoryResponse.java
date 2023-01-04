package com.retailer.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {
    private Long Id;
    private String sku;
    private boolean inStock;
}
