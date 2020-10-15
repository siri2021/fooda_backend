package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreDeliveryLocationsItemReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreDeliveryLocationsItemRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.dao.FoodaStoreDeliveryLocationRepository;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.service.FoodaStoreDeliveryLocationsService;

import java.util.List;
import java.util.stream.Collectors;

public class FoodaStoreDeliveryLocationsServiceImpl implements FoodaStoreDeliveryLocationsService<FoodaStoreDeliveryLocationsItemReq, FoodaStoreDeliveryLocationsItemRes> {
    FoodaStoreDeliveryLocationRepository deliveryLocationsRepo;
    private FoodaDtoMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> storeDtoMapper;

    @Override
    public List<FoodaStoreDeliveryLocationsItemRes> getByDeliveryLocation(Long municipalityId) {
        return deliveryLocationsRepo.findByDeliveryLocation(municipalityId)
                .stream()
                .map(storeDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreDeliveryLocationsItemRes> getStoreByDeliveryTime(Integer timeAsMinutes) {
        return deliveryLocationsRepo.findByDeliveryTime(timeAsMinutes)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }
}
