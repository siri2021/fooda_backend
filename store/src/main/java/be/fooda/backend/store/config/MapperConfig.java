package be.fooda.backend.store.config;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaStoreHttpMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public FoodaHttpMapper<FoodaStoreReq, FoodaStoreRes> getFoodaStoreHttpMapperBean() {
        return new FoodaStoreHttpMapper();
    }
}
