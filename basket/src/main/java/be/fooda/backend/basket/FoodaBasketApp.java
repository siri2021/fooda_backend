package be.fooda.backend.basket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodaBasketApp {
    public static void main(String[] args) {
        SpringApplication.run(FoodaBasketApp.class, args);
    }
}
