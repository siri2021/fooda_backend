package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.dao.repo.FoodaAddressRepository;
import be.fooda.backend.commons.dao.repo.FoodaContactRepository;
import be.fooda.backend.commons.model.template.store.dto.FoodaStoreDto;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreAddressReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreAuthItemReq;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class FoodaStoreMapper implements FoodaObjectMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> {

    private final FoodaContactRepository contactRepo;
    private final FoodaAddressRepository addressRepo;

    @Override
    public FoodaStoreReq dtoToRequest(FoodaStoreDto dto) {
        FoodaStoreReq req = FoodaStoreReq.builder().build();
        req.setAbout(dto.getAbout());
        addressRepo.findById(dto.getAddressId()).ifPresentOrElse(addressDto -> {
             req.setAddress(FoodaStoreAddressReq

                     .builder().build());
            // TODO map all addressReq properties to addressDto properties
        }, () -> {
            // TODO if fails map it to Map<String, Object>
        });

        List<FoodaStoreAuthItemReq> auth = Arrays.asList(

        );
        req.setAuth(auth);

        return null;
    }

    @Override
    public FoodaStoreReq responseToRequest(FoodaStoreRes res) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaStoreRes dtoToResponse(FoodaStoreDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaStoreRes requestToResponse(FoodaStoreReq req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaStoreDto requestToDto(FoodaStoreReq req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaStoreDto responseToDto(FoodaStoreRes res) {
        // TODO Auto-generated method stub
        return null;
    }

}