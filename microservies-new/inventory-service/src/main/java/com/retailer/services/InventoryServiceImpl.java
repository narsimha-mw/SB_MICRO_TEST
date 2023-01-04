package com.retailer.services;

import com.retailer.dto.InventoryResponse;
import com.retailer.repository.InventoryServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InventoryServiceImpl implements  InventoryService{

    @Autowired
    InventoryServiceRepository inventoryServiceRepository;
    @Override
    @Transactional(readOnly = true)
    public List<InventoryResponse> productInStock(List<String> sku) {
       return inventoryServiceRepository.findBySkuIn(sku)
               .stream()
               .map(inventory->
                   InventoryResponse.builder()
                           .sku(inventory.getSku())
                           .inStock(inventory.getQuantity() > 0)
                           .build()
               ).collect(Collectors.toList());
            }
}
