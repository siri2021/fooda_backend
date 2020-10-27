package be.fooda.backend.store.service.impl;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreTypeReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreWorkingHoursItemReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreTypeRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreWorkingHoursItemRes;
import be.fooda.backend.store.dao.FoodaStoreWorkingHoursRepository;
import be.fooda.backend.store.service.FoodaStoreWorkingHoursService;
import be.fooda.backend.store.service.mapper.FoodaStoreDtoMapper;
import be.fooda.backend.store.service.mapper.FoodaStoreWorkingHoursMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodaStoreWorkingHoursServiceImpl  implements FoodaStoreWorkingHoursService<FoodaStoreWorkingHoursItemReq, FoodaStoreWorkingHoursItemRes> {

    @Autowired
    FoodaStoreWorkingHoursRepository workingHoursRepo;

    @Autowired
    FoodaStoreWorkingHoursMapper storeWorkingHoursMapper;

    @Override
    public List<FoodaStoreWorkingHoursItemRes> getByWorkingHours(LocalDate date, LocalDateTime opens, LocalDateTime closes) {
        return workingHoursRepo.findByWorkingHours(date, opens, closes)
                .stream()
                .map(storeWorkingHoursMapper::dtoToResponse).collect(Collectors.toList());
    }

    @Override
    public List<FoodaStoreWorkingHoursItemRes> getByWorkingHours(LocalDateTime opens, LocalDateTime closes) {
        return workingHoursRepo.findByWorkingHours(opens, closes)
                .stream()
                .map(storeWorkingHoursMapper::dtoToResponse).collect(Collectors.toList());
    }
}
