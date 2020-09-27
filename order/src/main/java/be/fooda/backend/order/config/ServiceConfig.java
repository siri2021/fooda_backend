package be.fooda.backend.order.config;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.commons.service.mapper.FoodaOrderHttpMapper;
import be.fooda.backend.order.dao.FoodaOrderRepository;
import be.fooda.backend.order.service.FoodaOrderService;
import be.fooda.backend.order.service.impl.FoodaOrderServiceImpl;
import be.fooda.backend.order.service.mapper.FoodaOrderDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ServiceConfig {

    private final FoodaOrderRepository foodaOrderRepository;

    @Bean
    public FoodaOrderDtoMapper getFoodaOrderDtoMapper(){
        return new FoodaOrderDtoMapper();
    }

    @Bean
    public FoodaOrderHttpMapper getFoodaOrderHttpMapper(){
        return new FoodaOrderHttpMapper();
    }

    @Bean
    public FoodaOrderService<FoodaOrderReq, FoodaOrderRes> getFoodaOrderService(){
        return new FoodaOrderServiceImpl(
                foodaOrderRepository,
                getFoodaOrderDtoMapper(),
                getFoodaOrderHttpMapper()
        );
    }
}
