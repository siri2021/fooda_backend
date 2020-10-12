package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.contact.request.FoodaAddressReq;
import be.fooda.backend.commons.model.template.contact.response.FoodaAddressRes;
import org.springframework.stereotype.Component;

@Component
public class FoodaAddressHttpMapper implements FoodaHttpMapper<FoodaAddressReq, FoodaAddressRes> {

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

}