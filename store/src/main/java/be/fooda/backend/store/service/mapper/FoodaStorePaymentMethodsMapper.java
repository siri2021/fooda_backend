package be.fooda.backend.store.service.mapper;

import be.fooda.backend.commons.model.template.store.request.FoodaStorePaymentMethodsItemReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStorePaymentMethodsItemRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.FoodaStorePaymentMethodDto;
import org.springframework.stereotype.Component;

@Component
public class FoodaStorePaymentMethodsMapper implements FoodaDtoMapper<FoodaStorePaymentMethodDto , FoodaStorePaymentMethodsItemReq , FoodaStorePaymentMethodsItemRes> {

    @Override
    public FoodaStorePaymentMethodDto requestToDto(FoodaStorePaymentMethodsItemReq req) {
        return  FoodaStorePaymentMethodDto
                .builder()
                .expiryDate(req.getExpiry())
                .minOrderAmount(req.getMinOrderAmount())
                .build();
    }

    @Override
    public FoodaStorePaymentMethodDto responseToDto(FoodaStorePaymentMethodsItemRes res) {
        return FoodaStorePaymentMethodDto
                .builder()
                .minOrderAmount(res.getMinOrderAmount())
                .expiryDate(res.getExpiry())
                .build();
    }

    @Override
    public FoodaStorePaymentMethodsItemReq dtoToRequest(FoodaStorePaymentMethodDto dto) {
        return FoodaStorePaymentMethodsItemReq
                .builder()
                .expiry(dto.getExpiryDate())
                .minOrderAmount(dto.getMinOrderAmount())
                .build();
    }

    @Override
    public FoodaStorePaymentMethodsItemRes dtoToResponse(FoodaStorePaymentMethodDto dto) {
        return FoodaStorePaymentMethodsItemRes
                .builder()
                .minOrderAmount(dto.getMinOrderAmount())
                .expiry(dto.getExpiryDate())
                .build() ;

    }
}
