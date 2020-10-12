package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketOrderRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.FoodaBasketOrderService;
import be.fooda.backend.basket.service.mapper.FoodaBasketOrderDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketOrderReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketOrderRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketOrderHttpMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodaBasketOrderServiceImpl implements FoodaBasketOrderService<FoodaBasketOrderReq, FoodaBasketOrderRes> {

    @Autowired
    private FoodaBasketOrderRepository basketOrderRepo;

    @Autowired
    private FoodaBasketOrderDtoMapper basketOrderDtoMapper;

    @Autowired
    private FoodaBasketOrderHttpMapper basketOrderHttpMapper;

    @Override
    public Optional<FoodaBasketOrderRes> getBasketOrderById(String basketOrderId) {
        return basketOrderRepo
                .findById(new ObjectId(basketOrderId))
                .map(basketOrderDtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaBasketOrderRes> getBasketOrderByExample(FoodaBasketOrderReq foodaBasketOrderReq) {
        return Optional.empty();
    }

    @Override
    public List<FoodaBasketOrderRes> getBasketDeliveriesByBasketKey(Long userId, String session, Long storeId) {
        return basketOrderRepo
                .findAllByBasketKey(FoodaBasketKeyDto.builder()
                        .userId(userId)
                        .session(session)
                        .storeId(storeId)
                        .build())
                .stream()
                .map(basketOrderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaBasketOrderRes> getBasketDeliveriesByUser(Long userId, String session) {
        return basketOrderRepo
                .findAllByBasketKey_UserIdAndBasketKey_Session(userId, session)
                .stream()
                .map(basketOrderDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FoodaBasketOrderRes addBasketOrderAndReturn(FoodaBasketOrderReq foodaBasketOrderReq) {
        return basketOrderDtoMapper.dtoToResponse(
                basketOrderRepo.save(
                        basketOrderDtoMapper.requestToDto(foodaBasketOrderReq)));
    }

    @Override
    public Optional<FoodaBasketOrderRes> editBasketOrderByIdAndReturn(String basketOrderId, FoodaBasketOrderReq foodaBasketOrderReq) {
        return getBasketOrderById(basketOrderId)
                .map(res -> basketOrderHttpMapper
                        .requestToResponse(foodaBasketOrderReq)
                        .toBuilder()
                        .basketOrderId(basketOrderId)
                        .build())
                .map(res -> basketOrderDtoMapper.dtoToResponse(
                        basketOrderRepo.save(
                                basketOrderDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaBasketOrderRes> editBasketOrderByExampleAndReturn(FoodaBasketOrderReq foodaBasketOrderReq) {
        return getBasketOrderByExample(foodaBasketOrderReq)
                .map(res -> basketOrderHttpMapper.requestToResponse(foodaBasketOrderReq))
                .map(res -> basketOrderDtoMapper.dtoToResponse(
                        basketOrderRepo.save(
                                basketOrderDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaBasketOrderRes> removeBasketOrderByIdAndReturn(String basketOrderId) {
        final Optional<FoodaBasketOrderRes> foundOrder = getBasketOrderById(basketOrderId);
        foundOrder.ifPresent(res -> basketOrderRepo.deleteById(new ObjectId(basketOrderId)));
        final Optional<FoodaBasketOrderRes> oBasketOrderAfterDelete = getBasketOrderById(basketOrderId);
        if (oBasketOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaBasketOrderRes> removeBasketOrderByExampleAndReturn(FoodaBasketOrderReq foodaBasketOrderReq) {
        final Optional<FoodaBasketOrderRes> foundOrder = getBasketOrderByExample(foodaBasketOrderReq);
        foundOrder.ifPresent(res ->
                basketOrderRepo.delete(
                        basketOrderDtoMapper.requestToDto(foodaBasketOrderReq)));

        final Optional<FoodaBasketOrderRes> oBasketOrderAfterDelete = getBasketOrderByExample(foodaBasketOrderReq);
        if (oBasketOrderAfterDelete.isEmpty()) {
            return foundOrder;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean doesBasketOrderExistById(String basketOrderId) {
        return basketOrderRepo.existsById(new ObjectId(basketOrderId));
    }

    @Override
    public Boolean doesBasketOrderExistByExample(FoodaBasketOrderReq foodaBasketOrderReq) {
        return basketOrderRepo.exists(Example.of(basketOrderDtoMapper.requestToDto(foodaBasketOrderReq)));
    }
}
