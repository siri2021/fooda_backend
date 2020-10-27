package be.fooda.backend.store.service.mapper;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreWorkingHoursItemReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreWorkingHoursItemRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.FoodaStoreWorkingHoursDto;
import org.springframework.stereotype.Component;


@Component
public class FoodaStoreWorkingHoursMapper implements FoodaDtoMapper<FoodaStoreWorkingHoursDto, FoodaStoreWorkingHoursItemReq , FoodaStoreWorkingHoursItemRes> {

    @Override
    public FoodaStoreWorkingHoursDto requestToDto(FoodaStoreWorkingHoursItemReq req) {
        return FoodaStoreWorkingHoursDto
                .builder()
                .workingDate(req.getWorkingDate())
                .openTime(req.getOpenTime())
                .closeTime(req.getCloseTime())
                .build();
    }

    @Override
    public FoodaStoreWorkingHoursDto responseToDto(FoodaStoreWorkingHoursItemRes res) {
        return FoodaStoreWorkingHoursDto
                .builder()
                .workingDate(res.getWorkingDate())
                .openTime(res.getOpenTime())
                .closeTime(res.getCloseTime())
                .build();
    }



    @Override
    public FoodaStoreWorkingHoursItemReq dtoToRequest(FoodaStoreWorkingHoursDto dto) {
        return FoodaStoreWorkingHoursItemReq
                .builder()
                .workingDate(dto.getWorkingDate())
                .openTime(dto.getOpenTime())
                .closeTime(dto.getCloseTime())
                .build();
    }

    @Override
    public FoodaStoreWorkingHoursItemRes dtoToResponse(FoodaStoreWorkingHoursDto dto) {
        return FoodaStoreWorkingHoursItemRes
                .builder()
                .workingDate(dto.getWorkingDate())
                .openTime(dto.getOpenTime())
                .closeTime(dto.getCloseTime())
                .build();
    }
}
