package be.fooda.backend.user.config;

import be.fooda.backend.commons.model.template.user.request.FoodaUserReq;
import be.fooda.backend.commons.model.template.user.response.FoodaUserRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.commons.service.mapper.FoodaHttpMapper;
import be.fooda.backend.commons.service.mapper.FoodaUserHttpMapper;
import be.fooda.backend.user.model.dto.FoodaUserDto;
import be.fooda.backend.user.service.mapper.FoodaUserDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public FoodaDtoMapper<FoodaUserDto, FoodaUserReq, FoodaUserRes> dtoMapper() {
        return new FoodaUserDtoMapper();
    }

    @Bean
    public FoodaHttpMapper<FoodaUserReq, FoodaUserRes> httpMapper() {
        return new FoodaUserHttpMapper();
    }
}
