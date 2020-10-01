package be.fooda.backend.contact.config;

import be.fooda.backend.commons.service.mapper.FoodaContactHttpMapper;
import be.fooda.backend.contact.service.mapper.FoodaContactDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public FoodaContactDtoMapper contactDtoMapper(){
        return new FoodaContactDtoMapper();
    }

    @Bean
    public FoodaContactHttpMapper contactHttpMapper(){
        return new FoodaContactHttpMapper();
    }

}
