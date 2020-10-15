package be.fooda.backend.store.service.mapper;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

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
        dto.setName(req.getName());
        dto.setAbout(req.getAbout());

        return dto;
    }


    private List<FoodaStoreWorkingHoursDto> workingHoursAsDto(FoodaStoreReq req)
    {
        return req.getWorkingHours()
                .stream()
                .map( workHours -> {
                    FoodaStoreWorkingHoursDto hours=new FoodaStoreWorkingHoursDto();
                    hours.setWorkingDate(workHours.getWorkingDate());
                    hours.setOpenTime(workHours.getOpenTime());
                    hours.setCloseTime(workHours.getCloseTime());
                    return  hours;
                }).collect(Collectors.toList());

    }

    private List<FoodaStorePaymentMethodDto> paymentMethodsAsDto(FoodaStoreReq req) {
        return req.getPaymentMethods().stream().map(payments -> {
            FoodaStorePaymentMethodDto pays= new FoodaStorePaymentMethodDto();
            pays.setMinOrderAmount(payments.getMinOrderAmount());
            pays.setExpiryDate(payments.getExpiry());
        return pays;
        }).collect(Collectors.toList());

    }

    private FoodaStoreMediaDto logoImageAsDto(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStoreDeliveryLocationDto> deliveryLocationsAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreContactDto contactAsDto(FoodaStoreReq req) {
        FoodaStoreContactDto contactDto=new FoodaStoreContactDto();

        contactDto.setFirstName(req.getContact().getFirstName());
        contactDto.setLastName(req.getContact().getFamilyName());
        contactDto.setEmail(req.getContact().getEmail());
        contactDto.setPhone(req.getContact().getPhoneNumber());
        return contactDto;

    }

    private FoodaStoreMediaDto bgVideoAsDto(FoodaStoreReq req) {

    FoodaStoreMediaDto videoDto= new FoodaStoreMediaDto();
   // videoDto.set(req.getVideos());

        return videoDto;
    }

    private FoodaStoreMediaDto bgImageAsDto(FoodaStoreReq req) {
        FoodaStoreMediaDto imageDto = new FoodaStoreMediaDto();
        //imageDto.set(req.getImages());
        return imageDto;
    }

    private FoodaStoreAuthDto authAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreDeliveryCostDto deliveryCostAsDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreAddressDto addressAsDto(FoodaStoreReq req) {
        FoodaStoreAddressDto addressDto = new FoodaStoreAddressDto();
        addressDto.setAddressId(req.getAddress().getAddressId());
        addressDto.setPostcode(req.getAddress().getPostcode());
        addressDto.setMunicipality(req.getAddress().getMunicipality());
        addressDto.setCity(req.getAddress().getCity());
        return addressDto;
    }

    @Override
    public FoodaStoreDto responseToDto(FoodaStoreRes res) {
    FoodaStoreDto dto= new FoodaStoreDto();
        dto.setAddress(addressResAsDto(res));
        dto.addDeliveryCost(deliveryCostResAsDto(res));
        dto.setAuth(authRsAsDto(res));
        dto.setBgImage(bgImageResAsDto(res));
        dto.setBgVideo(bgVideoResAsDto(res));
        dto.setContact(contactResAsDto(res));
        dto.setDeliveryLocations(deliveryLocationsResAsDto(res));
        dto.setLogoImage(logoImageResAsDto(res));
        dto.setPaymentMethods(paymentMethodsResAsDto(res));
        dto.setWorkingHours(workingHoursResAsDto(res));
        dto.setName(res.getName());
        dto.setAbout(res.getAbout());

        return dto;
    }

    private List<FoodaStoreWorkingHoursDto> workingHoursResAsDto(FoodaStoreRes res) {
        return null;
    }

    private List<FoodaStorePaymentMethodDto> paymentMethodsResAsDto(FoodaStoreRes res) {
        return null;
    }

    private FoodaStoreMediaDto logoImageResAsDto(FoodaStoreRes res) {
        return null;
    }

    private List<FoodaStoreDeliveryLocationDto> deliveryLocationsResAsDto(FoodaStoreRes res) {
        return null;
    }

    private FoodaStoreContactDto contactResAsDto(FoodaStoreRes res) {
        return null;
    }

    private FoodaStoreMediaDto bgVideoResAsDto(FoodaStoreRes res) {
        return null;
    }

    private FoodaStoreMediaDto bgImageResAsDto(FoodaStoreRes res) {
        return null;
    }

    private FoodaStoreAuthDto authRsAsDto(FoodaStoreRes res) {
        return null;
    }

    private FoodaStoreDeliveryCostDto deliveryCostResAsDto(FoodaStoreRes res) {
        return null;
    }

    private FoodaStoreAddressDto addressResAsDto(FoodaStoreRes res) {
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
