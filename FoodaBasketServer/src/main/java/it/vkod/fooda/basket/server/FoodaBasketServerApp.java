package it.vkod.fooda.basket.server;

import it.vkod.fooda.basket.server.model.Product;
import it.vkod.fooda.basket.server.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class FoodaBasketServerApp {

    public static void main(String[] args) {
        SpringApplication.run(FoodaBasketServerApp.class, args);
    }

    @Bean
    CommandLineRunner runner(ProductService productService) {
        return args -> {
            productService.save(Product.builder().name("Pizza Margherita").price(12.00).pictureUrl("http://placehold.it/200x100").build());
            productService.save(Product.builder().name("Pizza Carbonara").price(18.00).pictureUrl("http://placehold.it/200x100").build());
            productService.save(Product.builder().name("Turkish Pizza").price(14.00).pictureUrl("http://placehold.it/200x100").build());
            productService.save(Product.builder().name("Pizza Salmonata").price(20.00).pictureUrl("http://placehold.it/200x100").build());
        };
    }
}
