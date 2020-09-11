package be.fooda.backend.media.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaProductReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaProductRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.media.model.dto.FoodaMediaProductDto;

public class FoodaMediaProductDtoMapper implements FoodaDtoMapper<FoodaMediaProductDto, FoodaMediaProductReq, FoodaMediaProductRes> {
    @Override
    public FoodaMediaProductDto requestToDto(FoodaMediaProductReq foodaMediaProductReq) {
        return null;
    }

    @Override
    public FoodaMediaProductDto responseToDto(FoodaMediaProductRes foodaMediaProductRes) {
        return null;
    }

    @Override
    public FoodaMediaProductReq dtoToRequest(FoodaMediaProductDto foodaMediaProductDto) {
        return null;
    }

    @Override
    public FoodaMediaProductRes dtoToResponse(FoodaMediaProductDto foodaMediaProductDto) {
        return null;
    }
}
