package com.retailer.services;

import com.retailer.repository.InventoryServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class InventoryServiceImpl implements  InventoryService{

    @Autowired
    InventoryServiceRepository inventoryServiceRepository;
    @Override
    @Transactional(readOnly = true)
    public boolean productInStock(String skuCode) {
       return inventoryServiceRepository.findBySkuCode(skuCode).isPresent();
            }
}
