package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketDeliveryDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketDeliveryRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;

public class FoodaBasketDeliveryDtoMapper implements FoodaDtoMapper<FoodaBasketDeliveryDto, FoodaBasketDeliveryReq, FoodaBasketDeliveryRes> {

    @Override
    public FoodaBasketDeliveryDto requestToDto(FoodaBasketDeliveryReq foodaBasketDeliveryReq) {
        return null;
    }

    @Override
    public FoodaBasketDeliveryDto responseToDto(FoodaBasketDeliveryRes foodaBasketDeliveryRes) {
        return null;
    }

    @Override
    public FoodaBasketDeliveryReq dtoToRequest(FoodaBasketDeliveryDto foodaBasketDeliveryDto) {
        return null;
    }

    @Override
    public FoodaBasketDeliveryRes dtoToResponse(FoodaBasketDeliveryDto foodaBasketDeliveryDto) {
        return null;
    }
}
