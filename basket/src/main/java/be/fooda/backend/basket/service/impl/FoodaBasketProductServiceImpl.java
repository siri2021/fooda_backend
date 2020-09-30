package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketProductRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.FoodaBasketProductService;
import be.fooda.backend.basket.service.mapper.FoodaBasketProductDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketProductReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketProductRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketProductHttpMapper;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FoodaBasketProductServiceImpl implements FoodaBasketProductService<FoodaBasketProductReq, FoodaBasketProductRes> {

    private final FoodaBasketProductRepository basketProductRepo;
    private final FoodaBasketProductDtoMapper basketProductDtoMapper;
    private final FoodaBasketProductHttpMapper basketProductHttpMapper;

    @Override
    public Optional<FoodaBasketProductRes> getBasketProductById(String basketProductId) {
        return basketProductRepo
                .findById(new ObjectId(basketProductId))
                .map(basketProductDtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaBasketProductRes> getBasketProductByExample(FoodaBasketProductReq foodaBasketProductReq) {
        return Optional.empty();
    }

    @Override
    public List<FoodaBasketProductRes> getBasketProductsByBasketKey(Long userId, String session, Long storeId) {
        return basketProductRepo
                .findAllByKey(FoodaBasketKeyDto.builder()
                        .userId(userId)
                        .session(session)
                        .storeId(storeId)
                        .build())
                .stream()
                .map(basketProductDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaBasketProductRes> getBasketProductsByUser(Long userId, String session) {
        return basketProductRepo
                .findAllByKey_UserIdAndKey_Session(userId, session)
                .stream()
                .map(basketProductDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<FoodaBasketProductRes> addBasketProductAndReturn(FoodaBasketProductReq foodaBasketProductReq) {
        return Optional.of(basketProductDtoMapper.dtoToResponse(
                basketProductRepo.save(
                        basketProductDtoMapper.requestToDto(foodaBasketProductReq))));
    }

    @Override
    public Optional<FoodaBasketProductRes> editBasketProductByIdAndReturn(String basketProductId, FoodaBasketProductReq foodaBasketProductReq) {
        return getBasketProductById(basketProductId)
                .map(res -> basketProductHttpMapper
                        .requestToResponse(foodaBasketProductReq)
                        .toBuilder()
                        .basketProductId(basketProductId)
                        .build())
                .map(res -> basketProductDtoMapper.dtoToResponse(
                        basketProductRepo.save(
                                basketProductDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaBasketProductRes> increaseBasketProductQuantityByIdAndReturn(String basketProductId, Integer quantity) {
        return getBasketProductById(basketProductId)
                .map(res -> {
                    res.increase(quantity);
                    return res;
                });
    }

    @Override
    public Optional<FoodaBasketProductRes> decreaseBasketProductQuantityByIdAndReturn(String basketProductId, Integer quantity) {
        return getBasketProductById(basketProductId)
                .map(res -> {
                    res.decrease(quantity);
                    return res;
                });
    }

    @Override
    public Optional<FoodaBasketProductRes> editBasketProductByExampleAndReturn(FoodaBasketProductReq foodaBasketProductReq) {
        return null;
    }

    @Override
    public Optional<FoodaBasketProductRes> removeBasketProductByIdAndReturn(String basketProductId) {
        final Optional<FoodaBasketProductRes> foundProduct = getBasketProductById(basketProductId);
        foundProduct.ifPresent(res -> basketProductRepo.deleteById(new ObjectId(basketProductId)));
        final Optional<FoodaBasketProductRes> oBasketProductAfterDelete = getBasketProductById(basketProductId);
        if (oBasketProductAfterDelete.isEmpty()) {
            return foundProduct;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaBasketProductRes> removeBasketProductByExampleAndReturn(FoodaBasketProductReq foodaBasketProductReq) {
        final Optional<FoodaBasketProductRes> foundProduct = getBasketProductByExample(foodaBasketProductReq);
        foundProduct.ifPresent(res ->
                basketProductRepo.delete(
                        basketProductDtoMapper.requestToDto(foodaBasketProductReq)));

        final Optional<FoodaBasketProductRes> oBasketProductAfterDelete = getBasketProductByExample(foodaBasketProductReq);
        if (oBasketProductAfterDelete.isEmpty()) {
            return foundProduct;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean doesBasketProductExistById(String basketProductId) {
        return basketProductRepo.existsById(new ObjectId(basketProductId));
    }

    @Override
    public Boolean doesBasketProductExistByExample(FoodaBasketProductReq foodaBasketProductReq) {
        return basketProductRepo.exists(Example.of(basketProductDtoMapper.requestToDto(foodaBasketProductReq)));
    }
}
