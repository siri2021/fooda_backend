package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;

public class FoodaStoreHttpMapper implements FoodaHttpMapper<FoodaStoreReq, FoodaStoreRes> {
    @Override
    public FoodaStoreReq responseToRequest(FoodaStoreRes foodaStoreRes) {
        return null;
    }

    @Override
    public FoodaStoreRes requestToResponse(FoodaStoreReq foodaStoreReq) {
        return null;
    }
}
