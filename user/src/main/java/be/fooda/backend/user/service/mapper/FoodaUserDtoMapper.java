package be.fooda.backend.user.service.mapper;

import be.fooda.backend.commons.model.template.user.request.FoodaUserReq;
import be.fooda.backend.commons.model.template.user.response.FoodaUserRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.user.model.dto.FoodaUserDto;

public class FoodaUserDtoMapper implements FoodaDtoMapper<FoodaUserDto, FoodaUserReq, FoodaUserRes> {
    @Override
    public FoodaUserDto requestToDto(FoodaUserReq foodaUserReq) {
        return null;
    }

    @Override
    public FoodaUserDto responseToDto(FoodaUserRes foodaUserRes) {
        return null;
    }

    @Override
    public FoodaUserReq dtoToRequest(FoodaUserDto foodaUserDto) {
        return null;
    }

    @Override
    public FoodaUserRes dtoToResponse(FoodaUserDto foodaUserDto) {
        return null;
    }
}
