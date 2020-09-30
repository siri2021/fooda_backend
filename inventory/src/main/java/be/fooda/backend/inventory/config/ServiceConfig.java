package be.fooda.backend.inventory.config;

import be.fooda.backend.commons.model.template.inventory.request.FoodaInventoryReq;
import be.fooda.backend.commons.model.template.inventory.response.FoodaInventoryRes;
import be.fooda.backend.commons.service.mapper.FoodaInventoryHttpMapper;
import be.fooda.backend.inventory.dao.FoodaInventoryRepository;
import be.fooda.backend.inventory.service.FoodaInventoryService;
import be.fooda.backend.inventory.service.impl.FoodaInventoryServiceImpl;
import be.fooda.backend.inventory.service.mapper.FoodaInventoryDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ServiceConfig {

    private final FoodaInventoryRepository foodaInventoryRepository;

    @Bean
    public FoodaInventoryDtoMapper getFoodaInventoryDtoMapper(){
        return new FoodaInventoryDtoMapper();
    }

    @Bean
    public FoodaInventoryHttpMapper getFoodaInventoryHttpMapper(){
        return new FoodaInventoryHttpMapper();
    }

    @Bean
    public FoodaInventoryService<FoodaInventoryReq, FoodaInventoryRes> getFoodaInventoryService(){
        return new FoodaInventoryServiceImpl(
                foodaInventoryRepository,
                getFoodaInventoryDtoMapper(),
                getFoodaInventoryHttpMapper()
        );
    }
}
