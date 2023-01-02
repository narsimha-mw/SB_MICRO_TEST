package com.product.productservice.services;

import com.product.productservice.dto.ProductRequest;
import com.product.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    void createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
