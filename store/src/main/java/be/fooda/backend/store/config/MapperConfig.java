package be.fooda.backend.store.config;

import be.fooda.backend.commons.service.mapper.FoodaStoreHttpMapper;
import be.fooda.backend.store.service.mapper.FoodaStoreDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public FoodaStoreDtoMapper getFoodaStoreDtoMapper() {
        return new FoodaStoreDtoMapper();
    }

    @Bean
    public FoodaStoreHttpMapper getFoodaStoreHttpMapper() {
        return new FoodaStoreHttpMapper();
    }

}
