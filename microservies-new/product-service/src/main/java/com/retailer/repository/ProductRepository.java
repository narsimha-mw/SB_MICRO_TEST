package com.retailer.repository;


import com.retailer.model.Product;
import org.springframework.data.repository.CrudRepository;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface ProductRepository extends CrudRepository<Product, Integer> {}
