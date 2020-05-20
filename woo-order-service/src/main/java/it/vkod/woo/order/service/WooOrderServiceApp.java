package it.vkod.woo.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WooOrderServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(WooOrderServiceApp.class, args);
    }
}