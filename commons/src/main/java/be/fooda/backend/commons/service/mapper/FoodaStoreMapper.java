package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.dao.repo.FoodaAddressRepository;
import be.fooda.backend.commons.dao.repo.FoodaContactRepository;
import be.fooda.backend.commons.model.template.contact.dto.FoodaAddressDto;
import be.fooda.backend.commons.model.template.store.dto.FoodaStoreDto;
import be.fooda.backend.commons.model.template.store.request.FoodaStoreRequest;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FoodaStoreMapper implements FoodaObjectMapper<FoodaStoreDto, FoodaStoreRequest, FoodaStoreResponse>{

    private final FoodaContactRepository contactRepo;
    private final FoodaAddressRepository addressRepo;

    @Override
    public FoodaStoreRequest dtoToRequest(FoodaStoreDto dto) {
        FoodaStoreRequest req = new FoodaStoreRequest();
        req.setAbout(dto.getAbout());
        addressRepo.findById(dto.getAddressId()).ifPresentOrElse(addressDto -> {
            
            req.setAddress();
        }, () -> {

        });

        return null;
    }

    @Override
    public FoodaStoreRequest responseToRequest(FoodaStoreResponse res) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaStoreResponse dtoToResponse(FoodaStoreDto dto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaStoreResponse requestToResponse(FoodaStoreRequest req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaStoreDto requestToDto(FoodaStoreRequest req) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public FoodaStoreDto responseToDto(FoodaStoreResponse res) {
        // TODO Auto-generated method stub
        return null;
    }

}