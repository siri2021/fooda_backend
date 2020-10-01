package be.fooda.backend.basket.service.impl;

import be.fooda.backend.basket.dao.FoodaBasketPaymentRepository;
import be.fooda.backend.basket.model.dto.FoodaBasketKeyDto;
import be.fooda.backend.basket.service.FoodaBasketPaymentService;
import be.fooda.backend.basket.service.mapper.FoodaBasketPaymentDtoMapper;
import be.fooda.backend.commons.model.template.basket.request.FoodaBasketPaymentReq;
import be.fooda.backend.commons.model.template.basket.response.FoodaBasketPaymentRes;
import be.fooda.backend.commons.service.mapper.FoodaBasketPaymentHttpMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodaBasketPaymentServiceImpl implements FoodaBasketPaymentService<FoodaBasketPaymentReq, FoodaBasketPaymentRes> {

    @Autowired
    private FoodaBasketPaymentRepository basketPaymentRepo;

    @Autowired
    private FoodaBasketPaymentDtoMapper basketPaymentDtoMapper;

    @Autowired
    private FoodaBasketPaymentHttpMapper basketPaymentHttpMapper;

    @Override
    public Optional<FoodaBasketPaymentRes> getBasketPaymentById(String basketPaymentId) {
        return basketPaymentRepo
                .findById(new ObjectId(basketPaymentId))
                .map(basketPaymentDtoMapper::dtoToResponse);
    }

    @Override
    public Optional<FoodaBasketPaymentRes> getBasketPaymentByExample(FoodaBasketPaymentReq foodaBasketPaymentReq) {
        return Optional.empty();
    }

    @Override
    public List<FoodaBasketPaymentRes> getBasketDeliveriesByBasketKey(Long userId, String session, Long storeId) {
        return basketPaymentRepo
                .findAllByBasketKey(FoodaBasketKeyDto.builder()
                        .userId(userId)
                        .session(session)
                        .storeId(storeId)
                        .build())
                .stream()
                .map(basketPaymentDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaBasketPaymentRes> getBasketDeliveriesByUser(Long userId, String session) {
        return basketPaymentRepo
                .findAllByBasketKey_UserIdAndBasketKey_Session(userId, session)
                .stream()
                .map(basketPaymentDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FoodaBasketPaymentRes addBasketPaymentAndReturn(FoodaBasketPaymentReq foodaBasketPaymentReq) {
        return basketPaymentDtoMapper.dtoToResponse(
                basketPaymentRepo.save(
                        basketPaymentDtoMapper.requestToDto(foodaBasketPaymentReq)));
    }

    @Override
    public Optional<FoodaBasketPaymentRes> editBasketPaymentByIdAndReturn(String basketPaymentId, FoodaBasketPaymentReq foodaBasketPaymentReq) {
        return getBasketPaymentById(basketPaymentId)
                .map(res -> basketPaymentHttpMapper
                        .requestToResponse(foodaBasketPaymentReq)
                        .toBuilder()
                        .basketPaymentId(basketPaymentId)
                        .build())
                .map(res -> basketPaymentDtoMapper.dtoToResponse(
                        basketPaymentRepo.save(
                                basketPaymentDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaBasketPaymentRes> editBasketPaymentByExampleAndReturn(FoodaBasketPaymentReq foodaBasketPaymentReq) {
        return getBasketPaymentByExample(foodaBasketPaymentReq)
                .map(res -> basketPaymentHttpMapper.requestToResponse(foodaBasketPaymentReq))
                .map(res -> basketPaymentDtoMapper.dtoToResponse(
                        basketPaymentRepo.save(
                                basketPaymentDtoMapper.responseToDto(res))));
    }

    @Override
    public Optional<FoodaBasketPaymentRes> removeBasketPaymentByIdAndReturn(String basketPaymentId) {
        final Optional<FoodaBasketPaymentRes> foundPayment = getBasketPaymentById(basketPaymentId);
        foundPayment.ifPresent(res -> basketPaymentRepo.deleteById(new ObjectId(basketPaymentId)));
        final Optional<FoodaBasketPaymentRes> oBasketPaymentAfterDelete = getBasketPaymentById(basketPaymentId);
        if (oBasketPaymentAfterDelete.isEmpty()) {
            return foundPayment;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<FoodaBasketPaymentRes> removeBasketPaymentByExampleAndReturn(FoodaBasketPaymentReq foodaBasketPaymentReq) {
        final Optional<FoodaBasketPaymentRes> foundPayment = getBasketPaymentByExample(foodaBasketPaymentReq);
        foundPayment.ifPresent(res ->
                basketPaymentRepo.delete(
                        basketPaymentDtoMapper.requestToDto(foodaBasketPaymentReq)));

        final Optional<FoodaBasketPaymentRes> oBasketPaymentAfterDelete = getBasketPaymentByExample(foodaBasketPaymentReq);
        if (oBasketPaymentAfterDelete.isEmpty()) {
            return foundPayment;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Boolean doesBasketPaymentExistById(String basketPaymentId) {
        return basketPaymentRepo.existsById(new ObjectId(basketPaymentId));
    }

    @Override
    public Boolean doesBasketPaymentExistByExample(FoodaBasketPaymentReq foodaBasketPaymentReq) {
        return basketPaymentRepo.exists(Example.of(basketPaymentDtoMapper.requestToDto(foodaBasketPaymentReq)));
    }
}
