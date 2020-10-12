package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.contact.request.FoodaContactReq;
import be.fooda.backend.commons.model.template.contact.response.FoodaContactRes;
import org.springframework.stereotype.Component;

@Component
public class FoodaContactHttpMapper implements FoodaHttpMapper<FoodaContactReq, FoodaContactRes> {

    @Override
    public FoodaContactRes requestToResponse(FoodaContactReq foodaContactReq) {
        FoodaContactRes res = new FoodaContactRes();
        res.setCanCall(foodaContactReq.getCanCall());
        res.setCompanyName(foodaContactReq.getCompanyName());
        res.setContactId(foodaContactReq.getContactId());
        res.setEmail(foodaContactReq.getEmail());
        res.setFamilyName(foodaContactReq.getFamilyName());
        res.setFirstName(foodaContactReq.getFirstName());
        res.setPhoneNumber(foodaContactReq.getPhoneNumber());
        res.setUserId(foodaContactReq.getUserId());
        return res;
    }

    @Override
    public FoodaContactReq responseToRequest(FoodaContactRes foodaContactRes){
        return FoodaContactReq.builder()
                .canCall(foodaContactRes.getCanCall())
                .companyName(foodaContactRes.getCompanyName())
                .contactId(foodaContactRes.getContactId())
                .email(foodaContactRes.getEmail())
                .familyName(foodaContactRes.getFamilyName())
                .firstName(foodaContactRes.getFirstName())
                .phoneNumber(foodaContactRes.getPhoneNumber())
                .userId(foodaContactRes.getUserId())
                .build();
    }
}
