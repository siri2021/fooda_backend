package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreTypeReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreTypeRes;
import be.fooda.backend.store.service.FoodaStoreTypeService;

import java.util.List;

public class FoodaStoreTypeServiceImpl implements FoodaStoreTypeService<FoodaStoreTypeReq, FoodaStoreTypeRes> {
    @Override
    public List<FoodaStoreTypeRes> getByType(String title) {
        return null;
    }
}
