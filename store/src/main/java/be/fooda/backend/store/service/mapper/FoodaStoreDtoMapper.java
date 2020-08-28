package be.fooda.backend.store.service.mapper;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.FoodaStoreDto;

public class FoodaStoreDtoMapper implements FoodaDtoMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> {

    @Override
    public FoodaStoreDto requestToDto(FoodaStoreReq foodaStoreReq) {
        return null;
    }

    @Override
    public FoodaStoreDto responseToDto(FoodaStoreRes foodaStoreRes) {
        return null;
    }

    @Override
    public FoodaStoreReq dtoToRequest(FoodaStoreDto foodaStoreDto) {
        return null;
    }

    @Override
    public FoodaStoreRes dtoToResponse(FoodaStoreDto foodaStoreDto) {
        return null;
    }
}
