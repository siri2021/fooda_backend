package be.fooda.backend.matching.config;

import be.fooda.backend.commons.service.mapper.FoodaMatchingMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatchConfig {

    @Bean
    public FoodaMatchingMapper getMapperBean() {
        return new FoodaMatchingMapper();
    }
}