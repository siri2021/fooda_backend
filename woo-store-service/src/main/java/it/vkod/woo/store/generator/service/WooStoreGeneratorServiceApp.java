package it.vkod.woo.store.generator.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class WooStoreGeneratorServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(WooStoreGeneratorServiceApp.class, args);
	}

}
