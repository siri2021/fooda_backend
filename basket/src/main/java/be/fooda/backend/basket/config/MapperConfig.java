package be.fooda.backend.basket.config;

import be.fooda.backend.basket.service.mapper.FoodaBasketDeliveryDtoMapper;
import be.fooda.backend.basket.service.mapper.FoodaBasketOrderDtoMapper;
import be.fooda.backend.basket.service.mapper.FoodaBasketPaymentDtoMapper;
import be.fooda.backend.basket.service.mapper.FoodaBasketProductDtoMapper;
import be.fooda.backend.commons.service.mapper.FoodaBasketDeliveryHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaBasketOrderHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaBasketPaymentHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaBasketProductHttpMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public FoodaBasketDeliveryDtoMapper getFoodaBasketDeliveryDtoMapper() {
        return new FoodaBasketDeliveryDtoMapper();
    }

    @Bean
    public FoodaBasketPaymentDtoMapper getFoodaBasketPaymentDtoMapper() {
        return new FoodaBasketPaymentDtoMapper();
    }

    @Bean
    public FoodaBasketOrderDtoMapper getFoodaBasketOrderDtoMapper() {
        return new FoodaBasketOrderDtoMapper();
    }

    @Bean
    public FoodaBasketProductDtoMapper getFoodaBasketProductDtoMapper() {
        return new FoodaBasketProductDtoMapper();
    }

    @Bean
    public FoodaBasketDeliveryHttpMapper getFoodaBasketDeliveryHttpMapper() {
        return new FoodaBasketDeliveryHttpMapper();
    }

    @Bean
    public FoodaBasketPaymentHttpMapper getFoodaBasketPaymentHttpMapper() {
        return new FoodaBasketPaymentHttpMapper();
    }

    @Bean
    public FoodaBasketOrderHttpMapper getFoodaBasketOrderHttpMapper() {
        return new FoodaBasketOrderHttpMapper();
    }

    @Bean
    public FoodaBasketProductHttpMapper getFoodaBasketProductHttpMapper() {
        return new FoodaBasketProductHttpMapper();
    }
}
