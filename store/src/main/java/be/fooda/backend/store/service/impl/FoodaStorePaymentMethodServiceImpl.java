package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStorePaymentMethodsItemReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreDeliveryCostsItemRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.dao.FoodaStorePaymentMethodRepository;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.service.FoodaStorePaymentMethodService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FoodaStorePaymentMethodServiceImpl implements FoodaStorePaymentMethodService<FoodaStorePaymentMethodsItemReq, FoodaStoreDeliveryCostsItemRes> {
    private FoodaDtoMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> storeDtoMapper;
    private FoodaStorePaymentMethodRepository paymentRepo;

    @Override
    public List<FoodaStoreDeliveryCostsItemRes> getStoreByPaymentMethodId(Long paymentMethodId, BigDecimal minOrderAmount) {
        return paymentRepo.findByPaymentMethodId(paymentMethodId, minOrderAmount)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreDeliveryCostsItemRes> getStoreByPaymentMethodId(Long paymentMethodId) {
        return paymentRepo.findByPaymentMethodId(paymentMethodId)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }
}
