package be.fooda.backend.product.config;

import be.fooda.backend.commons.config.HttpMapperConfig;
import be.fooda.backend.product.service.mapper.FoodaProductDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(HttpMapperConfig.class)
public class MapperConfig {

    @Bean
    public FoodaProductDtoMapper getFoodaProductDtoMapper() {
        return new FoodaProductDtoMapper();
    }
}
