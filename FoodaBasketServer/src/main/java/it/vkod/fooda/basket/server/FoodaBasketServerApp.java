package it.vkod.fooda.basket.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodaBasketServerApp {

    public static void main(String[] args) {
        SpringApplication.run(FoodaBasketServerApp.class, args);
    }
}
