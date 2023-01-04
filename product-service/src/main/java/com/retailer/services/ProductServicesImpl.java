package com.retailer.services;

import com.retailer.dto.ProductRequest;
import com.retailer.dto.ProductResponse;
import com.retailer.model.Product;
import com.retailer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServicesImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .sku(productRequest.getSku())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product was added {} successfully", product.getName());
    }

    @Override
    public List<ProductResponse> getProducts(ProductResponse productResponse) {
       List<Product> products = (List<Product>) productRepository.findAll();
       return products.stream().map(this::readProduct).collect(Collectors.toList());
    }

    private ProductResponse readProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .sku(product.getSku())
                .price(product.getPrice())
                .build();
    }
}
