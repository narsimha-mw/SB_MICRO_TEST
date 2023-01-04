package com.retailer.services;

import com.retailer.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    List<InventoryResponse> productInStock(List<String> sku);
}
