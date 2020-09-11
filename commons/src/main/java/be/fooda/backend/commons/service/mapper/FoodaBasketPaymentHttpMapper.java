package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;

public class FoodaBasketPaymentHttpMapper implements FoodaHttpMapper<FoodaBasketPaymentReq, FoodaBasketPaymentRes> {
    @Override
    public FoodaBasketPaymentReq responseToRequest(FoodaBasketPaymentRes foodaBasketPaymentRes) {
        return null;
    }

    @Override
    public FoodaBasketPaymentRes requestToResponse(FoodaBasketPaymentReq foodaBasketPaymentReq) {
        return null;
    }
}
