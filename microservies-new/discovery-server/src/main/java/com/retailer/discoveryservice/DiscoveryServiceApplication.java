package com.retailer.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@AutoConfiguration
@EnableEurekaServer
public class DiscoveryServiceApplication
{
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServiceApplication.class,args);
        System.err.println("discoveryservice is up..");

    }
}
