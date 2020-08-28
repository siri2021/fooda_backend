package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;

public class FoodaOrderHttpMapper implements FoodaHttpMapper<FoodaOrderReq, FoodaOrderRes> {
    @Override
    public FoodaOrderReq responseToRequest(FoodaOrderRes foodaOrderRes) {
        return null;
    }

    @Override
    public FoodaOrderRes requestToResponse(FoodaOrderReq foodaOrderReq) {
        return null;
    }
}
