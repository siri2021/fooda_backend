package be.fooda.backend.basket.config;

import be.fooda.backend.basket.dao.FoodaBasketDeliveryRepository;
import be.fooda.backend.basket.dao.FoodaBasketOrderRepository;
import be.fooda.backend.basket.dao.FoodaBasketPaymentRepository;
import be.fooda.backend.basket.dao.FoodaBasketProductRepository;
import be.fooda.backend.basket.service.FoodaBasketDeliveryService;
import be.fooda.backend.basket.service.FoodaBasketOrderService;
import be.fooda.backend.basket.service.FoodaBasketPaymentService;
import be.fooda.backend.basket.service.FoodaBasketProductService;
import be.fooda.backend.basket.service.impl.FoodaBasketDeliveryServiceImpl;
import be.fooda.backend.basket.service.impl.FoodaBasketOrderServiceImpl;
import be.fooda.backend.basket.service.impl.FoodaBasketPaymentServiceImpl;
import be.fooda.backend.basket.service.impl.FoodaBasketProductServiceImpl;
import be.fooda.backend.basket.service.mapper.FoodaBasketDeliveryDtoMapper;
import be.fooda.backend.basket.service.mapper.FoodaBasketOrderDtoMapper;
import be.fooda.backend.basket.service.mapper.FoodaBasketPaymentDtoMapper;
import be.fooda.backend.basket.service.mapper.FoodaBasketProductDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketDeliveryRes;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketDeliveryHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaBasketOrderHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaBasketPaymentHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaBasketProductHttpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ServiceConfig {

    private final FoodaBasketProductRepository basketProductRepository;
    private final FoodaBasketDeliveryRepository basketDeliveryRepository;
    private final FoodaBasketPaymentRepository basketPaymentRepository;
    private final FoodaBasketOrderRepository basketOrderRepository;

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

    @Bean
    public FoodaBasketProductService<FoodaBasketProductReq, FoodaBasketProductRes> getBasketProductService() {
        return new FoodaBasketProductServiceImpl(
                basketProductRepository,
                getFoodaBasketProductDtoMapper(),
                getFoodaBasketProductHttpMapper()
        );
    }

    @Bean
    public FoodaBasketDeliveryService<FoodaBasketDeliveryReq, FoodaBasketDeliveryRes> getBasketDeliveryService() {
        return new FoodaBasketDeliveryServiceImpl(
                basketDeliveryRepository,
                getFoodaBasketDeliveryDtoMapper(),
                getFoodaBasketDeliveryHttpMapper()
        );
    }

    @Bean
    public FoodaBasketPaymentService<FoodaBasketPaymentReq, FoodaBasketPaymentRes> getBasketPaymentService() {
        return new FoodaBasketPaymentServiceImpl(
                basketPaymentRepository,
                getFoodaBasketPaymentDtoMapper(),
                getFoodaBasketPaymentHttpMapper()
        );
    }

    @Bean
    public FoodaBasketOrderService<FoodaBasketOrderReq, FoodaBasketOrderRes> getBasketOrderService() {
        return new FoodaBasketOrderServiceImpl(
                basketOrderRepository,
                getFoodaBasketOrderDtoMapper(),
                getFoodaBasketOrderHttpMapper()
        );
    }
}
