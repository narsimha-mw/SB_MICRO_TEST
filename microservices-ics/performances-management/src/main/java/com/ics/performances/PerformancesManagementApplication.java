package com.ics.performances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PerformancesManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(PerformancesManagementApplication.class, args);
        
    }
}
