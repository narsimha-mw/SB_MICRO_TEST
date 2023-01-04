package com.inventory.inventoryservice;

import com.inventory.inventoryservice.model.Inventory;
import com.inventory.inventoryservice.repository.InventoryServiceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryServiceRepository inventoryServiceRepository) {
		return args -> {
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("Iphone_13");
			inventory1.setQuantity(2);
			Inventory inventory2 = new Inventory();
			inventory2.setSkuCode("Android_13");
			inventory2.setQuantity(0);
			inventoryServiceRepository.save(inventory1);
			inventoryServiceRepository.save(inventory2);
		};
	}
}
