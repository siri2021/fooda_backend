package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketDeliveryRes;

public class FoodaBasketDeliveryHttpMapper implements FoodaHttpMapper<FoodaBasketDeliveryReq, FoodaBasketDeliveryRes> {
    @Override
    public FoodaBasketDeliveryReq responseToRequest(FoodaBasketDeliveryRes foodaBasketDeliveryRes) {
        return null;
    }

    @Override
    public FoodaBasketDeliveryRes requestToResponse(FoodaBasketDeliveryReq foodaBasketDeliveryReq) {
        return null;
    }
}
