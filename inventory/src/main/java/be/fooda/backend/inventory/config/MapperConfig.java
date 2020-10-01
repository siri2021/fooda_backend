package be.fooda.backend.inventory.config;

import be.fooda.backend.commons.service.mapper.FoodaInventoryHttpMapper;
import be.fooda.backend.inventory.service.mapper.FoodaInventoryDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public FoodaInventoryDtoMapper getFoodaInventoryDtoMapper(){
        return new FoodaInventoryDtoMapper();
    }

    @Bean
    public FoodaInventoryHttpMapper getFoodaInventoryHttpMapper(){
        return new FoodaInventoryHttpMapper();
    }

}
