package com.retailer.controller;

import com.retailer.dto.InventoryResponse;
import com.retailer.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryServiceController {
    @Autowired
    InventoryService inventoryService;
    @GetMapping("/test")
    public String show(){
        return  "Inventory service is up now...one";
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> inStock(@RequestParam List<String> sku){
        System.err.println(sku);
       return inventoryService.productInStock(sku);
    }
}
