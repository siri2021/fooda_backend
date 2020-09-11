package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;

public class FoodaBasketOrderHttpMapper implements FoodaHttpMapper<FoodaBasketOrderReq, FoodaBasketOrderRes> {
    @Override
    public FoodaBasketOrderReq responseToRequest(FoodaBasketOrderRes foodaBasketOrderRes) {
        return null;
    }

    @Override
    public FoodaBasketOrderRes requestToResponse(FoodaBasketOrderReq foodaBasketOrderReq) {
        return null;
    }
}
