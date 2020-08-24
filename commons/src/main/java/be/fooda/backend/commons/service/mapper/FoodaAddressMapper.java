package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.contact.dto.FoodaAddressDto;
import be.fooda.backend.commons.model.template.contact.request.FoodaAddressReq;
import be.fooda.backend.commons.model.template.contact.response.FoodaAddressRes;

import lombok.*;

@RequiredArgsConstructor
public class FoodaAddressMapper implements FoodaObjectMapper<FoodaAddressDto, FoodaAddressReq, FoodaAddressRes> {
    @Override
    public FoodaAddressReq dtoToRequest(final FoodaAddressDto dto) {
        return FoodaAddressReq.builder()
                .addressId(dto.getAddressId())
                .city(dto.getCity())
                .country(dto.getCountry())
                .doorNo(dto.getDoorNo())
                .municipality(dto.getMunicipality())
                .number(dto.getNumber())
                .postcode(dto.getPostcode())
                .region(dto.getRegion())
                .street(dto.getStreet())
                .userId(dto.getUserId())
                .build();
    }

    @Override
    public FoodaAddressReq responseToRequest(final FoodaAddressRes res) {
        return FoodaAddressReq.builder()
                .addressId(res.getAddressId())
                .city(res.getCity())
                .country(res.getCountry())
                .doorNo(res.getDoorNo())
                .municipality(res.getMunicipality())
                .number(res.getNumber())
                .postcode(res.getPostcode())
                .region(res.getRegion())
                .street(res.getStreet())
                .userId(res.getUserId())
                .build();
    }

    @Override
    public FoodaAddressRes dtoToResponse(final FoodaAddressDto dto) {
        FoodaAddressRes res = new FoodaAddressRes();
        res.setAddressId(dto.getAddressId());
        res.setDoorNo(dto.getDoorNo());
        res.setNumber(dto.getNumber());
        res.setMunicipality(dto.getMunicipality());
        res.setPostcode(dto.getPostcode());
        res.setCity(dto.getCity());
        res.setRegion(dto.getRegion());
        res.setCountry(dto.getCountry());

        return res;
    }

    @Override
    public FoodaAddressRes requestToResponse(final FoodaAddressReq req) {
        FoodaAddressRes res = new FoodaAddressRes();
        res.setAddressId(req.getAddressId());
        res.setDoorNo(req.getDoorNo());
        res.setNumber(req.getNumber());
        res.setMunicipality(req.getMunicipality());
        res.setPostcode(req.getPostcode());
        res.setCity(req.getCity());
        res.setRegion(req.getRegion());
        res.setCountry(req.getCountry());

        return res;
    }

    @Override
    public FoodaAddressDto requestToDto(final FoodaAddressReq req) {
        return FoodaAddressDto.builder()
                .addressId(req.getAddressId())
                .city(req.getCity())
                .country(req.getCountry())
                .doorNo(req.getDoorNo())
                .municipality(req.getMunicipality())
                .number(req.getNumber())
                .postcode(req.getPostcode())
                .region(req.getRegion())
                .street(req.getStreet())
                .userId(req.getUserId())
                .build();
    }

    @Override
    public FoodaAddressDto responseToDto(final FoodaAddressRes res) {
        return FoodaAddressDto.builder()
                .addressId(res.getAddressId())
                .city(res.getCity())
                .country(res.getCountry())
                .doorNo(res.getDoorNo())
                .municipality(res.getMunicipality())
                .number(res.getNumber())
                .postcode(res.getPostcode())
                .region(res.getRegion())
                .street(res.getStreet())
                .userId(res.getUserId())
                .build();
    }

}