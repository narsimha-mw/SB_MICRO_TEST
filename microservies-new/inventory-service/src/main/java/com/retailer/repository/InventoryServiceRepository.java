package com.retailer.repository;

import com.retailer.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryServiceRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuIn(List<String> sku);
}
