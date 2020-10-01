package be.fooda.backend.product.configs;

import be.fooda.backend.commons.service.mapper.FoodaProductHttpMapper;
import be.fooda.backend.product.service.mapper.FoodaProductDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public FoodaProductDtoMapper getFoodaProductDtoMapper() {
        return new FoodaProductDtoMapper();
    }

    @Bean
    public FoodaProductHttpMapper getFoodaProductHttpMapper() {
        return new FoodaProductHttpMapper();
    }
}
