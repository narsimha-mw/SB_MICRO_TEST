package com.product.productservice.services;

import com.product.productservice.dto.ProductRequest;
import com.product.productservice.dto.ProductResponse;
import com.product.productservice.model.Product;
import com.product.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
//@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public void createProduct(ProductRequest productRequest) {
        Product products = Product.builder()
                        .name(productRequest.getName())
                                .description(productRequest.getDescription())
                                        .price(productRequest.getPrice())
                                                .build();
        productRepository.save(products);
         log.info("product {} is saved", products.getName());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
//        products.stream().map(product->mapToProductResponse(product));
      return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return  ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }
}
