package be.fooda.backend.store.service.mapper;



import be.fooda.backend.commons.model.template.store.request.FoodaStoreAuthItemReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreAuthItemRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.FoodaStoreAuthDto;
import org.springframework.stereotype.Component;

@Component
public class FoodaStoreAuthDtoMapper implements FoodaDtoMapper<FoodaStoreAuthDto, FoodaStoreAuthItemReq, FoodaStoreAuthItemRes> {

    @Override
    public FoodaStoreAuthDto requestToDto(FoodaStoreAuthItemReq foodaStoreAuthItemReq) {
        return FoodaStoreAuthDto.builder()
                .expiryDate(foodaStoreAuthItemReq.getExpiry())
                .key(foodaStoreAuthItemReq.getKey())
                .secret(foodaStoreAuthItemReq.getSecret()).build();
    }

    @Override
    public FoodaStoreAuthDto responseToDto(FoodaStoreAuthItemRes foodaStoreAuthItemRes) {
        return FoodaStoreAuthDto.builder()
                .expiryDate(foodaStoreAuthItemRes.getExpiry())
                .secret(foodaStoreAuthItemRes.getSecret())
                .key(foodaStoreAuthItemRes.getKey()).build();
    }

    @Override
    public FoodaStoreAuthItemReq dtoToRequest(FoodaStoreAuthDto foodaStoreAuthDto) {
        return FoodaStoreAuthItemReq.builder().expiry(foodaStoreAuthDto.getExpiryDate())
                .secret(foodaStoreAuthDto.getSecret())
                .key(foodaStoreAuthDto.getKey()).build();
    }

    @Override
    public FoodaStoreAuthItemRes dtoToResponse(FoodaStoreAuthDto foodaStoreAuthDto) {
        return FoodaStoreAuthItemRes.builder().expiry(foodaStoreAuthDto.getExpiryDate())
                .secret(foodaStoreAuthDto.getSecret())
                .key(foodaStoreAuthDto.getKey()).build();
    }
}
