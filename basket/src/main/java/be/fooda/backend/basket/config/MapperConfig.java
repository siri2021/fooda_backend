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
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {

    @Bean
    public FoodaBasketProductHttpMapper productHttpMapper() {
        return new FoodaBasketProductHttpMapper();
    }

    @Bean
    @Primary
    public FoodaBasketProductDtoMapper productDtoMapper() {
        return new FoodaBasketProductDtoMapper();
    }

    @Bean
    public FoodaBasketDeliveryHttpMapper deliveryHttpMapper() {
        return new FoodaBasketDeliveryHttpMapper();
    }

    @Bean
    @Primary
    public FoodaBasketDeliveryDtoMapper deliveryDtoMapper() {
        return new FoodaBasketDeliveryDtoMapper();
    }

    @Bean
    public FoodaBasketPaymentHttpMapper paymentHttpMapper() {
        return new FoodaBasketPaymentHttpMapper();
    }

    @Bean
    @Primary
    public FoodaBasketPaymentDtoMapper paymentDtoMapper() {
        return new FoodaBasketPaymentDtoMapper();
    }

    @Bean
    public FoodaBasketOrderHttpMapper orderHttpMapper() {
        return new FoodaBasketOrderHttpMapper();
    }

    @Bean
    @Primary
    public FoodaBasketOrderDtoMapper orderDtoMapper() {
        return new FoodaBasketOrderDtoMapper();
    }

}
