package be.fooda.backend.product.configs;

import be.fooda.backend.commons.model.template.product.request.FoodaProductReq;
import be.fooda.backend.commons.model.template.product.response.FoodaProductRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.commons.service.mapper.FoodaHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaProductHttpMapper;
import be.fooda.backend.product.model.dto.FoodaProductDto;
import be.fooda.backend.product.service.mapper.FoodaProductDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public FoodaDtoMapper<FoodaProductDto, FoodaProductReq, FoodaProductRes> dtoMapper() {
        return new FoodaProductDtoMapper();
    }

    @Bean
    public FoodaHttpMapper<FoodaProductReq, FoodaProductRes> httpMapper() {
        return new FoodaProductHttpMapper();
    }
}
