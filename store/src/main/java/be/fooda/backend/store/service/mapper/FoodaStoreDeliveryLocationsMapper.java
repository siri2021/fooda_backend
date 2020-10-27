package be.fooda.backend.store.service.mapper;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreDeliveryLocationsItemReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreDeliveryLocationsItemRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.FoodaStoreDeliveryLocationDto;
import org.springframework.stereotype.Component;

@Component
public class FoodaStoreDeliveryLocationsMapper implements FoodaDtoMapper<FoodaStoreDeliveryLocationDto , FoodaStoreDeliveryLocationsItemReq , FoodaStoreDeliveryLocationsItemRes>{

    @Override
    public FoodaStoreDeliveryLocationDto requestToDto(FoodaStoreDeliveryLocationsItemReq req) {
        return FoodaStoreDeliveryLocationDto
                .builder()
                .municipalityId(req.getMunicipalityId())
                .deliveryTime(req.getDeliveryTime())
                .minOrderPrice(req.getMinOrderPrice())
                .maxOrderPrice(req.getMaxOrderPrice())
                .deliveryCost(req.getDeliveryCost())
                .build();
    }

    @Override
    public FoodaStoreDeliveryLocationDto responseToDto(FoodaStoreDeliveryLocationsItemRes res) {
        return FoodaStoreDeliveryLocationDto
                .builder()
                .municipalityId(res.getMunicipalityId())
                .deliveryTime(res.getDeliveryTime())
                .minOrderPrice(res.getMinOrderPrice())
                .maxOrderPrice(res.getMaxOrderPrice())
                .deliveryCost(res.getDeliveryCost())
                .build();
    }

    @Override
    public FoodaStoreDeliveryLocationsItemReq dtoToRequest(FoodaStoreDeliveryLocationDto dto) {
        return FoodaStoreDeliveryLocationsItemReq
                .builder()
                .municipalityId(dto.getMunicipalityId())
                .deliveryTime(dto.getDeliveryTime())
                .minOrderPrice(dto.getMinOrderPrice())
                .maxOrderPrice(dto.getMaxOrderPrice())
                .deliveryCost(dto.getDeliveryCost())
                .build();
    }

    @Override
    public FoodaStoreDeliveryLocationsItemRes dtoToResponse(FoodaStoreDeliveryLocationDto dto) {
        return FoodaStoreDeliveryLocationsItemRes
                .builder()
                .municipalityId(dto.getMunicipalityId())
                .deliveryTime(dto.getDeliveryTime())
                .minOrderPrice(dto.getMinOrderPrice())
                .maxOrderPrice(dto.getMaxOrderPrice())
                .deliveryCost(dto.getDeliveryCost())
                .build() ;
    }
}
