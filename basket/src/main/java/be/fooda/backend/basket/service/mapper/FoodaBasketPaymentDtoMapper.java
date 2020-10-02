package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.model.dto.FoodaBasketPaymentDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FoodaBasketPaymentDtoMapper implements FoodaDtoMapper<FoodaBasketPaymentDto, FoodaBasketPaymentReq, FoodaBasketPaymentRes> {

    @Override
    public FoodaBasketPaymentDto requestToDto(FoodaBasketPaymentReq req) {
        return FoodaBasketPaymentDto.builder()
                .basketKey(FoodaBasketKeyDto.builder()
                        .userId(req.getUserId())
                        .session(req.getSession())
                        .storeId(req.getStoreId())
                        .build())
                .amount(req.getAmount())
                .paymentId(req.getPaymentId())
                .build();
    }

    @Override
    public FoodaBasketPaymentDto responseToDto(FoodaBasketPaymentRes res) {
        return FoodaBasketPaymentDto.builder()
                .basketKey(FoodaBasketKeyDto.builder()
                        .userId(res.getStoreId())
                        .session(res.getSession())
                        .storeId(res.getStoreId())
                        .build())
                .paymentId(res.getPaymentId())
                .basketPaymentId(res.getBasketPaymentId())
                .amount(res.getAmount())
                .build();
    }

    @Override
    public FoodaBasketPaymentReq dtoToRequest(FoodaBasketPaymentDto dto) {
        return FoodaBasketPaymentReq.builder()
                .userId(dto.getBasketKey().getUserId())
                .session(dto.getBasketKey().getSession())
                .storeId(dto.getBasketKey().getStoreId())
                .paymentId(dto.getPaymentId())
                .amount(dto.getAmount())
                .build();
    }

    @Override
    public FoodaBasketPaymentRes dtoToResponse(FoodaBasketPaymentDto dto) {
        return FoodaBasketPaymentRes.builder()
                .userId(dto.getBasketKey().getUserId())
                .session(dto.getBasketKey().getSession())
                .storeId(dto.getBasketKey().getStoreId())
                .paymentId(dto.getPaymentId())
                .basketPaymentId(dto.getBasketPaymentId())
                .amount(dto.getAmount())
                .build();
    }
}