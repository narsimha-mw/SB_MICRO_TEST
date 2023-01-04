package com.retailer.controller;

import com.retailer.dto.ProductRequest;
import com.retailer.dto.ProductResponse;
import com.retailer.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
//@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/test")
    public  String show(){
        System.err.println("show message--------------------");
        return  "Product server is running...";
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody  ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(ProductResponse productResponse){
      return productService.getProducts(productResponse);
    }
}
