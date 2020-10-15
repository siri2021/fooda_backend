package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreDeliveryCostsItemReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreDeliveryCostsItemRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.dao.FoodaStoreDeliveryCostRepository;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.service.FoodaStoreDeliveryCostService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class FoodaStoreDeliveryCostServiceImpl implements FoodaStoreDeliveryCostService<FoodaStoreDeliveryCostsItemReq, FoodaStoreDeliveryCostsItemRes> {
    FoodaStoreDeliveryCostRepository deliveryCostRepo;
    private FoodaDtoMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> storeDtoMapper;


    @Override
    public List<FoodaStoreRes> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice, final BigDecimal amount) {
        return deliveryCostRepo.findByDeliveryCost(minPrice, maxPrice, amount)
                .stream()
                .map(storeDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreRes> getStoreByDeliveryCost(final BigDecimal minPrice, final BigDecimal maxPrice) {
        return deliveryCostRepo.findByDeliveryCost(minPrice, maxPrice)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }
}