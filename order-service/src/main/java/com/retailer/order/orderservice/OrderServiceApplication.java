package com.retailer.order.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) {

		System.err.println("Order services is up");
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}
