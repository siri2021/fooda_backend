package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.order.request.FoodaOrderReq;
import be.fooda.backend.commons.model.template.order.response.FoodaOrderRes;
import be.fooda.backend.order.model.dto.FoodaOrderDto;

@Deprecated
public class FoodaOrderMapper implements FoodaObjectMapper<FoodaOrderDto, FoodaOrderReq, FoodaOrderRes>{

    @Override
    public FoodaOrderReq dtoToRequest(FoodaOrderDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaOrderReq responseToRequest(FoodaOrderRes res) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaOrderRes dtoToResponse(FoodaOrderDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaOrderRes requestToResponse(FoodaOrderReq req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaOrderDto requestToDto(FoodaOrderReq req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaOrderDto responseToDto(FoodaOrderRes res) {
        // TODO Auto-generated method stub
        return null;
    }

}