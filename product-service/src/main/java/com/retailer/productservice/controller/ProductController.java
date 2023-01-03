package com.retailer.productservice.controller;

import com.retailer.productservice.dto.ProductRequest;
import com.retailer.productservice.dto.ProductResponse;
import com.retailer.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping(path = "/api/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/test")
    public  String show(){
        System.err.println("show message--------------------");
        return  "server is running...";
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
