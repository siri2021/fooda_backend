package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;

public class FoodaBasketProductHttpMapper implements FoodaHttpMapper<FoodaBasketProductReq, FoodaBasketProductRes> {
    @Override
    public FoodaBasketProductReq responseToRequest(FoodaBasketProductRes foodaBasketProductRes) {
        return null;
    }

    @Override
    public FoodaBasketProductRes requestToResponse(FoodaBasketProductReq foodaBasketProductReq) {
        return null;
    }
}
