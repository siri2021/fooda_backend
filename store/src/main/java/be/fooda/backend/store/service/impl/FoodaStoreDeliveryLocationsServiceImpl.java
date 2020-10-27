package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreDeliveryLocationsItemReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreDeliveryLocationsItemRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.dao.FoodaStoreDeliveryLocationRepository;
import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.service.FoodaStoreDeliveryLocationsService;
import be.fooda.backend.store.service.mapper.FoodaStoreDeliveryLocationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodaStoreDeliveryLocationsServiceImpl implements FoodaStoreDeliveryLocationsService<FoodaStoreDeliveryLocationsItemReq, FoodaStoreDeliveryLocationsItemRes> {

    @Autowired
    private FoodaStoreDeliveryLocationRepository deliveryLocationsRepo;

    @Autowired
    private FoodaStoreDeliveryLocationsMapper storeDeliveryLocationsDtoMapper;

    @Override
    public List<FoodaStoreDeliveryLocationsItemRes> getByDeliveryLocation(Long municipalityId) {
        return deliveryLocationsRepo.findByDeliveryLocation(municipalityId)
                .stream()
                .map(storeDeliveryLocationsDtoMapper::dtoToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreDeliveryLocationsItemRes> getStoreByDeliveryTime(Integer timeAsMinutes) {
        return deliveryLocationsRepo.findByDeliveryTime(timeAsMinutes)
                .stream()
                .map(storeDeliveryLocationsDtoMapper::dtoToResponse).collect(Collectors.toList());
    }
}
