package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketAddressDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketAddressReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketAddressRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;

public class FoodaBasketAddressDtoMapper implements FoodaDtoMapper<FoodaBasketAddressDto, FoodaBasketAddressReq, FoodaBasketAddressRes> {
    @Override
    public FoodaBasketAddressDto requestToDto(FoodaBasketAddressReq foodaBasketAddressReq) {
        return null;
    }

    @Override
    public FoodaBasketAddressDto responseToDto(FoodaBasketAddressRes foodaBasketAddressRes) {
        return null;
    }

    @Override
    public FoodaBasketAddressReq dtoToRequest(FoodaBasketAddressDto foodaBasketAddressDto) {
        return null;
    }

    @Override
    public FoodaBasketAddressRes dtoToResponse(FoodaBasketAddressDto foodaBasketAddressDto) {
        return null;
    }
}
