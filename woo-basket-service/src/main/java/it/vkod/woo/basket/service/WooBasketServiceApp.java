package it.vkod.woo.basket.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WooBasketServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(WooBasketServiceApp.class, args);
    }
}
