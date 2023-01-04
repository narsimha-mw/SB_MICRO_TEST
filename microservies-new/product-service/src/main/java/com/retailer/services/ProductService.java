package com.retailer.services;

import com.retailer.dto.ProductRequest;
import com.retailer.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getProducts(ProductResponse productResponse);
}
