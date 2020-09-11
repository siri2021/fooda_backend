package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketPaymentDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;

public class FoodaBasketPaymentDtoMapper implements FoodaDtoMapper<FoodaBasketPaymentDto, FoodaBasketPaymentReq, FoodaBasketPaymentRes> {

    @Override
    public FoodaBasketPaymentDto requestToDto(FoodaBasketPaymentReq foodaBasketPaymentReq) {
        return null;
    }

    @Override
    public FoodaBasketPaymentDto responseToDto(FoodaBasketPaymentRes foodaBasketPaymentRes) {
        return null;
    }

    @Override
    public FoodaBasketPaymentReq dtoToRequest(FoodaBasketPaymentDto foodaBasketPaymentDto) {
        return null;
    }

    @Override
    public FoodaBasketPaymentRes dtoToResponse(FoodaBasketPaymentDto foodaBasketPaymentDto) {
        return null;
    }
}
