package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketDeliveryRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.FoodaBasketDeliveryService;
import be.fooda.backend.basket.service.mapper.FoodaBasketDeliveryDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketDeliveryReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketDeliveryRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketDeliveryHttpMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodaBasketDeliveryServiceImpl implements FoodaBasketDeliveryService<FoodaBasketDeliveryReq, FoodaBasketDeliveryRes> {

    @Autowired
    private FoodaBasketDeliveryRepository basketDeliveryRepo;

    @Autowired
    private FoodaBasketDeliveryDtoMapper basketDeliveryDtoMapper;

    @Autowired
    private FoodaBasketDeliveryHttpMapper basketDeliveryHttpMapper;

    @Override
    public Optional<FoodaBasketDeliveryRes> getBasketDeliveryById(String basketDeliveryId) {
        return basketDeliveryRepo
                .findById(new ObjectId(basketDeliveryId))
                .map(basketDeliveryDtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaBasketDeliveryRes> getBasketDeliveryByExample(FoodaBasketDeliveryReq foodaBasketDeliveryReq) {
        return Optional.empty();
    }

    @Override
    public List<FoodaBasketDeliveryRes> getBasketDeliveriesByBasketKey(Long userId, String session, Long storeId) {
        return basketDeliveryRepo
                .findAllByBasketKey(FoodaBasketKeyDto.builder()
                        .userId(userId)
                        .session(session)
                        .storeId(storeId)
                        .build())
                .stream()
                .map(basketDeliveryDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaBasketDeliveryRes> getBasketDeliveriesByUser(Long userId, String session) {
        return basketDeliveryRepo
                .findAllByBasketKey_UserIdAndBasketKey_Session(userId, session)
                .stream()
                .map(basketDeliveryDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FoodaBasketDeliveryRes addBasketDeliveryAndReturn(FoodaBasketDeliveryReq foodaBasketDeliveryReq) {
        return basketDeliveryDtoMapper.dtoToResponse(
                basketDeliveryRepo.save(
                        basketDeliveryDtoMapper.requestToDto(foodaBasketDeliveryReq)));
    }

    @Override
    public Optional<FoodaBasketDeliveryRes> editBasketDeliveryByIdAndReturn(String basketDeliveryId, FoodaBasketDeliveryReq foodaBasketDeliveryReq) {
        return getBasketDeliveryById(basketDeliveryId)
                .map(res -> basketDeliveryHttpMapper
                        .requestToResponse(foodaBasketDeliveryReq)
                        .toBuilder()
                        .basketDeliveryId(basketDeliveryId)
                        .build())
                .map(res -> basketDeliveryDtoMapper.dtoToResponse(
                        basketDeliveryRepo.save(
                                basketDeliveryDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaBasketDeliveryRes> editBasketDeliveryByExampleAndReturn(FoodaBasketDeliveryReq foodaBasketDeliveryReq) {
        return getBasketDeliveryByExample(foodaBasketDeliveryReq)
                .map(res -> basketDeliveryHttpMapper.requestToResponse(foodaBasketDeliveryReq))
                .map(res -> basketDeliveryDtoMapper.dtoToResponse(
                        basketDeliveryRepo.save(
                                basketDeliveryDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaBasketDeliveryRes> removeBasketDeliveryByIdAndReturn(String basketDeliveryId) {
        final Optional<FoodaBasketDeliveryRes> foundDelivery = getBasketDeliveryById(basketDeliveryId);
        foundDelivery.ifPresent(res -> basketDeliveryRepo.deleteById(new ObjectId(basketDeliveryId)));
        final Optional<FoodaBasketDeliveryRes> oBasketDeliveryAfterDelete = getBasketDeliveryById(basketDeliveryId);
        if (oBasketDeliveryAfterDelete.isEmpty()) {
            return foundDelivery;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaBasketDeliveryRes> removeBasketDeliveryByExampleAndReturn(FoodaBasketDeliveryReq foodaBasketDeliveryReq) {
        final Optional<FoodaBasketDeliveryRes> foundDelivery = getBasketDeliveryByExample(foodaBasketDeliveryReq);
        foundDelivery.ifPresent(res ->
                basketDeliveryRepo.delete(
                        basketDeliveryDtoMapper.requestToDto(foodaBasketDeliveryReq)));

        final Optional<FoodaBasketDeliveryRes> oBasketDeliveryAfterDelete = getBasketDeliveryByExample(foodaBasketDeliveryReq);
        if (oBasketDeliveryAfterDelete.isEmpty()) {
            return foundDelivery;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean doesBasketDeliveryExistById(String basketDeliveryId) {
        return basketDeliveryRepo.existsById(new ObjectId(basketDeliveryId));
    }

    @Override
    public Boolean doesBasketDeliveryExistByExample(FoodaBasketDeliveryReq foodaBasketDeliveryReq) {
        return basketDeliveryRepo.exists(Example.of(basketDeliveryDtoMapper.requestToDto(foodaBasketDeliveryReq)));
    }
}
