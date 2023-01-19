package com.retailer.serviceregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudServiceRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceRegisterApplication.class, args);
	}

}
