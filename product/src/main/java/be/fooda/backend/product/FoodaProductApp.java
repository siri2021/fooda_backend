package be.fooda.backend.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodaProductApp {

    public static void main(String[] args) {
        SpringApplication.run(FoodaProductApp.class, args);
    }

}
