package be.fooda.backend.matching;

import be.fooda.backend.commons.service.mapper.FoodaMatchingMapper;
import be.fooda.backend.commons.service.util.FoodaMatchUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAutoConfiguration
public class FoodaMatchingApp {

	public static void main(String[] args) {
		SpringApplication.run(FoodaMatchingApp.class, args);
	}

	@Bean
	public FoodaMatchingMapper loadMapper() {
		return new FoodaMatchingMapper(new FoodaMatchUtil());
	}
}
