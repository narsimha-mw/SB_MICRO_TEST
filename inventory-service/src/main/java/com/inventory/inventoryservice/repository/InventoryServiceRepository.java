package com.inventory.inventoryservice.repository;

import com.inventory.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryServiceRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
