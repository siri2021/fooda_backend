package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreTypeReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreTypeRes;
import be.fooda.backend.store.dao.FoodaStoreWorkingHoursRepository;
import be.fooda.backend.store.service.FoodaStoreWorkingHoursService;
import be.fooda.backend.store.service.mapper.FoodaStoreDtoMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FoodaStoreWorkingHoursServiceImpl  implements FoodaStoreWorkingHoursService<FoodaStoreTypeReq, FoodaStoreTypeRes> {
    FoodaStoreWorkingHoursRepository workingHoursRepo;
    FoodaStoreDtoMapper storeDtoMapper;

    @Override
    public List<FoodaStoreTypeRes> getByWorkingHours(LocalDate date, LocalDateTime opens, LocalDateTime closes) {
        return workingHoursRepo.findByWorkingHours(date, opens, closes)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreTypeRes> getByWorkingHours(LocalDateTime opens, LocalDateTime closes) {
        return workingHoursRepo.findByWorkingHours(opens, closes)
                .stream()
                .map(storeDtoMapper::dtoToResponse).collect(Collectors.toList());
    }
}
