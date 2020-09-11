package be.fooda.backend.matching;

import be.fooda.backend.commons.service.mapper.FoodaMatchingHttpMapper;
import be.fooda.backend.matching.service.mapper.FoodaMatchingDtoMapper;
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
	public FoodaMatchingDtoMapper loadDtoMapper() {
		return new FoodaMatchingDtoMapper();
	}

	@Bean
	public FoodaMatchingHttpMapper loadHttpMapper() {
		return new FoodaMatchingHttpMapper();
	}
}
