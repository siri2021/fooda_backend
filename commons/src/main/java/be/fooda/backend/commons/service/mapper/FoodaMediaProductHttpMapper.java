package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaProductReq;
import be.fooda.backend.commons.model.template.media.response.FoodaMediaProductRes;
import org.springframework.stereotype.Component;

@Component
public class FoodaMediaProductHttpMapper implements FoodaHttpMapper<FoodaMediaProductReq, FoodaMediaProductRes> {
    @Override
    public FoodaMediaProductReq responseToRequest(FoodaMediaProductRes foodaMediaProductRes) {
        return null;
    }

    @Override
    public FoodaMediaProductRes requestToResponse(FoodaMediaProductReq foodaMediaProductReq) {
        return null;
    }
}
