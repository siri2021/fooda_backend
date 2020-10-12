package be.fooda.backend.contact.service.mapper;

import be.fooda.backend.commons.model.template.contact.request.FoodaAddressReq;
import be.fooda.backend.commons.model.template.contact.response.FoodaAddressRes;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.contact.model.dto.FoodaAddressCityDto;
import be.fooda.backend.contact.model.dto.FoodaAddressDto;
import be.fooda.backend.contact.model.dto.FoodaAddressMunicipalityDto;
import be.fooda.backend.contact.model.dto.FoodaAddressRegionDto;
import org.springframework.stereotype.Component;

@Component
public class FoodaAddressDtoMapper implements FoodaDtoMapper<FoodaAddressDto, FoodaAddressReq, FoodaAddressRes> {

    @Override
    public FoodaAddressReq dtoToRequest(final FoodaAddressDto dto) {
        return FoodaAddressReq.builder()
                .addressId(dto.getAddressId())
                .city(city(dto))
                .country(country(dto))
                .doorNo(dto.getDoorNo())
                .municipality(municipality(dto))
                .number(dto.getNumber())
                .postcode(postcode(dto))
                .region(region(dto))
                .street(dto.getStreet())
                .userId(dto.getUserId())
                .build();
    }

    private String city(final FoodaAddressDto dto) {
        return dto.getMunicipality().getCity().getName();
    }

    private String country(final FoodaAddressDto dto) {
        return dto.getMunicipality().getCity().getRegion().getCountry().getName();
    }

    private String municipality(final FoodaAddressDto dto) {
        return dto.getMunicipality().getName();
    }

    private String postcode(final FoodaAddressDto dto) {
        return dto.getMunicipality().getPostcode();
    }

    private String region(final FoodaAddressDto dto) {
        return dto.getMunicipality().getCity().getRegion().getName();
    }

    @Override
    public FoodaAddressRes dtoToResponse(final FoodaAddressDto dto) {
        FoodaAddressRes res = new FoodaAddressRes();
        res.setAddressId(dto.getAddressId());
        res.setDoorNo(dto.getDoorNo());
        res.setNumber(dto.getNumber());
        res.setMunicipality(dto.getMunicipality().getName());
        res.setPostcode(dto.getMunicipality().getPostcode());
        res.setCity(dto.getMunicipality().getCity().getName());
        res.setRegion(dto.getMunicipality().getCity().getRegion().getName());
        res.setCountry(dto.getMunicipality().getCity().getRegion().getCountry().getName());

        return res;
    }

    @Override
    public FoodaAddressDto requestToDto(final FoodaAddressReq req) {
        return FoodaAddressDto.builder()
                .addressId(req.getAddressId())
                .userId(req.getUserId())
                .doorNo(req.getDoorNo())
                .number(req.getNumber())
                .street(req.getStreet())
                .municipality(municipality(req))
                .build();
    }

    private FoodaAddressMunicipalityDto municipality(final FoodaAddressReq req) {
        return FoodaAddressMunicipalityDto.builder()
                .name(req.getMunicipality())
                .postcode(req.getPostcode())
                .build();
    }

    private FoodaAddressCityDto city(final FoodaAddressReq req) {
        return FoodaAddressCityDto.builder().name(req.getCity()).build();
    }

    private FoodaAddressRegionDto region(final FoodaAddressReq req) {
        return FoodaAddressRegionDto.builder().name(req.getRegion()).build();
    }

    @Override
    public FoodaAddressDto responseToDto(final FoodaAddressRes res) {
        return FoodaAddressDto.builder()
                .addressId(res.getAddressId())
                .userId(res.getUserId())
                .doorNo(res.getDoorNo())
                .number(res.getNumber())
                .street(res.getStreet())
                .municipality(municipality(res))
                .build();
    }

    private FoodaAddressMunicipalityDto municipality(FoodaAddressRes res) {
        return FoodaAddressMunicipalityDto.builder()
                .name(res.getMunicipality())
                .postcode(res.getPostcode())
                .build();
    }

}