package be.fooda.backend.basket.service.mapper;

import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.model.dto.FoodaBasketProductDto;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FoodaBasketProductDtoMapper implements FoodaDtoMapper<FoodaBasketProductDto, FoodaBasketProductReq, FoodaBasketProductRes> {

    @Override
    public FoodaBasketProductDto requestToDto(FoodaBasketProductReq req) {
        return FoodaBasketProductDto.builder()
                .description(req.getDescription())
                .imageUrl(req.getImageUrl())
                .key(keyReq(req))
                .name(req.getName())
                .price(req.getPrice())
                .productId(req.getProductId())
                .quantity(req.getQuantity())
                .build();
    }

    private FoodaBasketKeyDto keyReq(FoodaBasketProductReq req) {
        return FoodaBasketKeyDto.builder()
                .session(req.getSession())
                .storeId(req.getStoreId())
                .userId(req.getUserId())
                .build();
    }

    @Override
    public FoodaBasketProductDto responseToDto(FoodaBasketProductRes res) {
        return FoodaBasketProductDto.builder()
                .quantity(res.getQuantity())
                .productId(res.getProductId())
                .price(res.getPrice())
                .name(res.getName())
                .key(keyRes(res))
                .imageUrl(res.getImageUrl())
                .description(res.getDescription())
                .basketProductId(res.getBasketProductId())
                .build();
    }

    private FoodaBasketKeyDto keyRes(FoodaBasketProductRes res) {
        return FoodaBasketKeyDto.builder()
                .userId(res.getUserId())
                .storeId(res.getStoreId())
                .session(res.getSession())
                .build();
    }

    @Override
    public FoodaBasketProductReq dtoToRequest(FoodaBasketProductDto dto) {
        return FoodaBasketProductReq.builder()
                .storeId(dto.getKey().getStoreId())
                .session(dto.getKey().getSession())
                .userId(dto.getKey().getUserId())
                .quantity(dto.getQuantity())
                .productId(dto.getProductId())
                .price(dto.getPrice())
                .name(dto.getName())
                .imageUrl(dto.getImageUrl())
                .description(dto.getDescription())
                .build();
    }

    @Override
    public FoodaBasketProductRes dtoToResponse(FoodaBasketProductDto dto) {
        return FoodaBasketProductRes.builder()
                .storeId(dto.getKey().getStoreId())
                .session(dto.getKey().getSession())
                .userId(dto.getKey().getUserId())
                .quantity(dto.getQuantity())
                .productId(dto.getProductId())
                .price(dto.getPrice())
                .name(dto.getName())
                .imageUrl(dto.getImageUrl())
                .description(dto.getDescription())
                .basketProductId(dto.getBasketProductId())
                .build();
    }
}