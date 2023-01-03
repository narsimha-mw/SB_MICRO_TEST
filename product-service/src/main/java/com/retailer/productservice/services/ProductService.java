package com.retailer.productservice.services;

import com.retailer.productservice.dto.ProductRequest;
import com.retailer.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts(ProductResponse productResponse);
}
