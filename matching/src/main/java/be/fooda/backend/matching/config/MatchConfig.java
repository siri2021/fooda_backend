package be.fooda.backend.matching.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import be.fooda.backend.matching.service.mappers.KeywordMapper;

@Configuration
public class MatchConfig {

    @Bean
    public KeywordMapper getMapperBean() {
        return new KeywordMapper();
    }
}