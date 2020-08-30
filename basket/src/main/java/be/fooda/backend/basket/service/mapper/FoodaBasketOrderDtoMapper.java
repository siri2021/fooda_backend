package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketOrderDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;

public class FoodaBasketOrderDtoMapper implements FoodaDtoMapper<FoodaBasketOrderDto, FoodaBasketOrderReq, FoodaBasketOrderRes> {

    @Override
    public FoodaBasketOrderDto requestToDto(FoodaBasketOrderReq foodaBasketOrderReq) {
        return null;
    }

    @Override
    public FoodaBasketOrderDto responseToDto(FoodaBasketOrderRes foodaBasketOrderRes) {
        return null;
    }

    @Override
    public FoodaBasketOrderReq dtoToRequest(FoodaBasketOrderDto foodaBasketOrderDto) {
        return null;
    }

    @Override
    public FoodaBasketOrderRes dtoToResponse(FoodaBasketOrderDto foodaBasketOrderDto) {
        return null;
    }
}
