package be.fooda.backend.store.service.mapper;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public class FoodaStoreDtoGetSetMapper implements FoodaDtoMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> {

    @Override
    public FoodaStoreDto requestToDto(FoodaStoreReq req) {
        FoodaStoreDto dto = new FoodaStoreDto();
        dto.setAddress(addressAsDto(req));
        dto.addDeliveryCost(deliveryCostAsDto(req));
        dto.setAuth(authAsDto(req));
        dto.setBgImage(bgImageAsDto(req));
        dto.setBgVideo(bgVideoAsDto(req));
        dto.setContact(contactAsDto(req));
        dto.setDeliveryLocations(deliveryLocationsAsDto(req));
        dto.setLogoImage(logoImageAsDto(req));
        dto.setPaymentMethods(paymentMethodsAsDto(req));
        dto.setWorkingHours(workingHoursAsDto(req));

        //TODO add simple data types setter here ..

        return dto;
    }

    private List<FoodaStoreWorkingHoursDto> workingHoursAsDto(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStorePaymentMethodDto> paymentMethodsAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreMediaDto logoImageAsDto(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStoreDeliveryLocationDto> deliveryLocationsAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreContactDto contactAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreMediaDto bgVideoAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreMediaDto bgImageAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreAuthDto authAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreDeliveryCostDto deliveryCostAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreAddressDto addressAsDto(FoodaStoreReq req) {
        FoodaStoreAddressDto addressDto = new FoodaStoreAddressDto();
        addressDto.setAddressId(null); //  TODO please add addressId postcode to commons module in request and response..
        addressDto.setPostcode(null); // TODO please add postcode to commons module in request and response..
        // ...
        return addressDto;
    }

    @Override
    public FoodaStoreDto responseToDto(FoodaStoreRes res) {
        return null;
    }

    @Override
    public FoodaStoreReq dtoToRequest(FoodaStoreDto dto) {
        return null;
    }

    @Override
    public FoodaStoreRes dtoToResponse(FoodaStoreDto dto) {
        return null;
    }
}
