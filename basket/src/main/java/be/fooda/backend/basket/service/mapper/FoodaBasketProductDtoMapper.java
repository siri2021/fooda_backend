package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketProductDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;

public class FoodaBasketProductDtoMapper implements FoodaDtoMapper<FoodaBasketProductDto, FoodaBasketProductReq, FoodaBasketProductRes> {

    @Override
    public FoodaBasketProductDto requestToDto(FoodaBasketProductReq foodaBasketProductReq) {
        return null;
    }

    @Override
    public FoodaBasketProductDto responseToDto(FoodaBasketProductRes foodaBasketProductRes) {
        return null;
    }

    @Override
    public FoodaBasketProductReq dtoToRequest(FoodaBasketProductDto foodaBasketProductDto) {
        return null;
    }

    @Override
    public FoodaBasketProductRes dtoToResponse(FoodaBasketProductDto foodaBasketProductDto) {
        return null;
    }
}
