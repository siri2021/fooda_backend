package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.user.request.FoodaUserReq;
import be.fooda.backend.commons.model.template.user.response.FoodaUserRes;

public class FoodaUserHttpMapper implements FoodaHttpMapper<FoodaUserReq, FoodaUserRes> {

    @Override
    public FoodaUserReq responseToRequest(FoodaUserRes foodaUserRes) {
        return null;
    }

    @Override
    public FoodaUserRes requestToResponse(FoodaUserReq foodaUserReq) {
        return null;
    }
}
