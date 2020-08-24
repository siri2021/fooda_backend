package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.contact.dto.FoodaContactDto;
import be.fooda.backend.commons.model.template.contact.request.FoodaContactReq;
import be.fooda.backend.commons.model.template.contact.response.FoodaContactRes;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FoodaContactMapper implements FoodaObjectMapper<FoodaContactDto, FoodaContactReq, FoodaContactRes> {

    @Override
    public FoodaContactReq dtoToRequest(FoodaContactDto foodaContactDto) {
        return FoodaContactReq.builder()
                .canCall(foodaContactDto.getCanCall())
                .companyName(foodaContactDto.getCompanyName())
                .contactId(foodaContactDto.getContactId())
                .email(foodaContactDto.getEmail())
                .familyName(foodaContactDto.getFamilyName())
                .firstName(foodaContactDto.getFirstName())
                .phoneNumber(foodaContactDto.getPhoneNumber())
                .userId(foodaContactDto.getUserId())
                .build();
    }

    @Override
    public FoodaContactRes dtoToResponse(FoodaContactDto foodaContactDto) {
        FoodaContactRes res = new FoodaContactRes();
        res.setCanCall(foodaContactDto.getCanCall());
        res.setCompanyName(foodaContactDto.getCompanyName());
        res.setContactId(foodaContactDto.getContactId());
        res.setEmail(foodaContactDto.getEmail());
        res.setFamilyName(foodaContactDto.getFamilyName());
        res.setFirstName(foodaContactDto.getFirstName());
        res.setPhoneNumber(foodaContactDto.getPhoneNumber());
        res.setUserId(foodaContactDto.getUserId());
        return res;
    }

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
    public FoodaContactDto requestToDto(FoodaContactReq foodaContactReq) {
        return FoodaContactDto.builder()
                .canCall(foodaContactReq.getCanCall())
                .companyName(foodaContactReq.getCompanyName())
                .contactId(foodaContactReq.getContactId())
                .email(foodaContactReq.getEmail())
                .familyName(foodaContactReq.getFamilyName())
                .firstName(foodaContactReq.getFirstName())
                .phoneNumber(foodaContactReq.getPhoneNumber())
                .userId(foodaContactReq.getUserId())
                .build();
    }

    @Override
    public FoodaContactDto responseToDto(FoodaContactRes foodaContactRes) {
        return FoodaContactDto.builder()
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
