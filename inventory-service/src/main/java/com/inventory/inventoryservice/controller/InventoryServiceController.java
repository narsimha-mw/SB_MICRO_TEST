package com.inventory.inventoryservice.controller;

import com.inventory.inventoryservice.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryServiceController {
    @Autowired
    InventoryService inventoryService;
    @GetMapping("/inventory/test")
    public String show(){
        return  "Inventory service is up now...one";
    }
    @GetMapping(path = "/inventory/stock/?sku={skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public boolean inStock(@PathVariable("skuCode") String skuCode){
        System.err.println(skuCode);
       return inventoryService.productInStock(skuCode);
    }
}
