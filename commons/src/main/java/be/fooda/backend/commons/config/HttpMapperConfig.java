package be.fooda.backend.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import be.fooda.backend.commons.service.mapper.FoodaProductHttpMapper;

@Configuration
public class HttpMapperConfig {

    @Bean
    public FoodaProductHttpMapper getFoodaProductHttpMapperAsBean(){
        return new FoodaProductHttpMapper();
    }
    
}
