package com.retailer.productservice.repository;

import com.retailer.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
