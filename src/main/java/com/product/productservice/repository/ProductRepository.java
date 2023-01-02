package com.product.productservice.repository;

import com.product.productservice.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,String>
{

}
