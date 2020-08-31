package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.store.dto.*;
import be.fooda.backend.commons.model.template.store.request.*;

import be.fooda.backend.commons.model.template.store.response.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FoodaStoreMapper implements FoodaObjectMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> {


    @Override
    public FoodaStoreReq dtoToRequest(FoodaStoreDto dto) {
        return FoodaStoreReq.builder()
                .storeUrl(dto.getStoreUrl())
                .workingHours(workHours(dto))
                .name(dto.getName())
                .logo(logoAsReq(dto))
                .slogan(dto.getSlogan())
                .type(type(dto))
                .about(dto.getAbout())
                .deliveryLocations(deliveryLocationsAsReq(dto))
                .deliveryCosts(deliveryCostsAsReq(dto))
                .paymentMethods(paymentMethodsAsReq(dto))
                .build();
    }

    private List<FoodaStorePaymentMethodsItemReq> paymentMethodsAsReq(FoodaStoreDto dto) {
        return dto.getPaymentMethods().stream().map(payments -> FoodaStorePaymentMethodsItemReq.builder()
                .minOrderAmount(payments.getMinOrderAmount())
                .build()).collect(Collectors.toList());
    }



    private FoodaStoreTypeReq type(FoodaStoreDto dto) {
        return FoodaStoreTypeReq.builder().title(dto.getType().getTitle()).build();
    }

    private FoodaStoreLogoReq logoAsReq(FoodaStoreDto dto) {
        return FoodaStoreLogoReq.builder().url(dto.getSiteUrl()).build();

    }

    private FoodaStoreLogoRes logoAsRes(FoodaStoreDto dto) {
        return null;
    }

    private List<FoodaStoreDeliveryLocationsItemReq> deliveryLocationsAsReq(final FoodaStoreDto dto) {
        return dto.getDeliveryLocations()
                .stream().map(loc -> FoodaStoreDeliveryLocationsItemReq.builder()
                        .deliveryTime(loc.getDeliveryTime())
                        .deliveryCost(loc.getDeliveryCost())
                        .build()).collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryLocationsItemRes> deliveryLocationsAsRes(final FoodaStoreDto dto) {
        return dto.getDeliveryLocations().stream().map(locs -> FoodaStoreDeliveryLocationsItemRes
                .builder()
                .deliveryCost(locs.getDeliveryCost())
                .deliveryTime(locs.getDeliveryTime())
                .build()).collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryCostsItemReq> deliveryCostsAsReq(final FoodaStoreDto dto) {
        return dto.getDeliveryCosts().
                stream()
                .map(costs -> FoodaStoreDeliveryCostsItemReq.builder()
                        .amount(costs.getAmount())
                        .maxPrice(costs.getMaxPrice())
                        .minPrice(costs.getMinPrice())
                        .build()).collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryCostsItemRes> deliveryCostsAsRes(final FoodaStoreDto dto) {
        return dto.getDeliveryCosts().stream().map(costs -> FoodaStoreDeliveryCostsItemRes.builder()
                .amount(costs.getAmount())
                .minPrice(costs.getMinPrice())
                .maxPrice(costs.getMaxPrice())
                .build()).collect(Collectors.toList());
    }

    private List<FoodaStoreWorkingHoursItemReq> workHours(final FoodaStoreDto dto) {
        return dto.getWorkingHours().stream().map(hours -> FoodaStoreWorkingHoursItemReq.builder()
                .closeTime(hours.getCloseTime())
                .openTime(hours.getOpenTime())
                .build()).collect(Collectors.toList());
    }


    @Override
    public FoodaStoreReq responseToRequest(FoodaStoreRes res) {
        return FoodaStoreReq.builder()
                .name(res.getName())
                .contact(contact(res))
                .videos(videos(res))
                .paymentMethods(paymentMethodsResToReq(res))
                .images(images(res))
                .deliveryCosts(deliveryCostsAsReq(res))
                .deliveryLocations(deliveryLocationsAsReq(res))
                .about(res.getAbout())
                .address(address(res))
                .type(typeAsReq(res))
                .slogan(res.getSlogan())
                .logo(logoAsReq(res))
                .workingHours(workingHours(res))
                .storeUrl(res.getStoreUrl())
                .siteUrl(res.getSiteUrl())
                .auth(auth(res))
                .storeId(res.getStoreId())
                .build();


    }

    private List<FoodaStoreAuthItemReq> auth(FoodaStoreRes res) {

        return res.getAuth().stream().map(auth -> FoodaStoreAuthItemReq.builder()
         .key(auth.getKey())
        .secret(auth.getSecret())
        .expiry(auth.getExpiry())
        .build()).collect(Collectors.toList());
    }



    private List<FoodaStoreWorkingHoursItemReq> workingHours(FoodaStoreRes res) {
        return res.getWorkingHours().stream()
                .map(hours -> FoodaStoreWorkingHoursItemReq
                        .builder()
                        .openTime(hours.getOpenTime())
                        .closeTime(hours.getCloseTime())
                        .workingDate(hours.getWorkingDate())
                        .build())
                .collect(Collectors.toList());
    }


    private FoodaStoreLogoReq logoAsReq(FoodaStoreRes res) {
        return FoodaStoreLogoReq.builder().url(res.getLogo().getUrl()).build();
    }

    private FoodaStoreTypeReq typeAsReq(FoodaStoreRes res) {
        return FoodaStoreTypeReq.builder().title(res.getType().getTitle()).build();
    }

    private FoodaStoreTypeDto typeAsDto(FoodaStoreRes res) {

        return FoodaStoreTypeDto.builder().title(res.getType().getTitle()).build() ;

    }

    private FoodaStoreAddressReq address(FoodaStoreRes res) {
        return FoodaStoreAddressReq.builder().doorNo(res.getAddress().getDoorNo())
                .street(res.getAddress().getStreet())
                .city(res.getAddress().getCity())
                .region(res.getAddress().getRegion())
                .municipality(res.getAddress().getMunicipality())
                .country(res.getAddress().getCountry())
                .number(res.getAddress().getNumber())
                .build();
    }

    private List<FoodaStoreDeliveryLocationsItemReq> deliveryLocationsAsReq(FoodaStoreRes res) {
        return res.getDeliveryLocations().stream().map(locs -> FoodaStoreDeliveryLocationsItemReq.builder()
                .city(locs.getCity())
                .country(locs.getCountry())
                .deliveryCost(locs.getDeliveryCost())
                .deliveryTime(locs.getDeliveryTime())
                .municipality(locs.getMunicipality())
                .region(locs.getRegion())
                .build()).collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryCostsItemReq> deliveryCostsAsReq(FoodaStoreRes res) {
        return res.getDeliveryCosts().stream().map(costs -> FoodaStoreDeliveryCostsItemReq.builder()
                .amount(costs.getAmount())
                .minPrice(costs.getMinPrice())
                .maxPrice(costs.getMaxPrice())
                .build()).collect(Collectors.toList());
    }

    private List<FoodaStoreImagesItemReq> images(FoodaStoreRes res) {
        return res.getImages().stream().map(images -> FoodaStoreImagesItemReq.builder()
                .title(res.getType().getTitle()).build()).collect(Collectors.toList());
    }

    private List<FoodaStorePaymentMethodsItemReq> paymentMethodsResToReq(FoodaStoreRes res) {
        return res.getPaymentMethods().stream().map(payments -> FoodaStorePaymentMethodsItemReq.builder()
                .title(payments.getTitle())
                .minOrderAmount(payments.getMinOrderAmount())
                .expiry(payments.getExpiry())
                .build()).collect(Collectors.toList());
    }



    private FoodaStoreContactReq contact(FoodaStoreRes res) {
        return res.getContact().;
    }

    private List<FoodaStoreVideosItemReq> videos(FoodaStoreRes res) {
        FoodaStoreRes res1 = new FoodaStoreRes();
        res.setAbout("safabuhjfba");
        return null;
    }


    @Override
    public FoodaStoreRes dtoToResponse(FoodaStoreDto dto) {
        return FoodaStoreRes.builder()
                .about(dto.getAbout())
                .auth(auth(dto))
                .deliveryCosts(deliveryCostsAsRes(dto))
                .deliveryLocations(deliveryLocationsAsRes(dto))
                .logo(logoAsRes(dto))
                .images(images(dto))
                .paymentMethods(paymentMethodsAsRes(dto))
                .build();
    }
    private List<FoodaStorePaymentMethodsItemRes> paymentMethodsAsRes(FoodaStoreDto dto) {
        return null;

    }

    private List<FoodaStoreImagesItemRes> images(FoodaStoreDto dto) {
        return null;
    }

    private List<FoodaStoreAuthItemRes> auth(FoodaStoreDto dto) {
        return null;
    }

    @Override
    public FoodaStoreRes requestToResponse(FoodaStoreReq req) {
        return FoodaStoreRes.builder().paymentMethods(paymentMethodsReqToRes()).images(imagesReqToRes(req)).build();
    }

    private List<FoodaStoreImagesItemRes> imagesReqToRes(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStorePaymentMethodsItemRes> paymentMethodsReqToRes() {
        return null;
    }

    @Override
    public FoodaStoreDto requestToDto(FoodaStoreReq req) {
        return FoodaStoreDto.builder()
                .name(req.getName())
                .bgImageId(bgImageId(req))
                .bgVideoId(bgVideoId(req))
                .contactId(req.getContact().getStoreContactId())
                .deliveryCosts(deliveryCostsReqToDto(req))
                .deliveryLocations(deliveryLocationsReqToDto(req))
                .logoImageId(logoReqToDto(req))
                .paymentMethods(paymentMethodsReqToDto(req))
                .siteUrl(req.getSiteUrl())
                .storeUrl(req.getStoreUrl())
                .type(typeReqToDto(req))
                .workingHours(workingHoursReqToDto(req))
                .auth(authReqToDto(req))
                .about(req.getAbout())
                .build();
    }

    private Long bgVideoId(FoodaStoreReq req) {
        return null;
    }

    private Long bgImageId(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStoreDeliveryCostDto> deliveryCostsReqToDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreAuthDto authReqToDto(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStoreWorkingHoursDto> workingHoursReqToDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreTypeDto typeReqToDto(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStorePaymentMethodDto> paymentMethodsReqToDto(FoodaStoreReq req) {
        return null;
    }

    private Long logoReqToDto(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStoreDeliveryLocationDto> deliveryLocationsReqToDto(FoodaStoreReq req) {
        return null;
    }

    private FoodaStoreAuthDto auth(FoodaStoreReq req) {
        return null;
    }

    private List<FoodaStoreWorkingHoursDto> workingHours(FoodaStoreReq req) {
        return null;
    }

    @Override
    public FoodaStoreDto responseToDto(FoodaStoreRes res) {
        return FoodaStoreDto.builder()
                .name(res.getName())
                .bgImageId(bgImageId(res))
                .bgVideoId(bgVideoId(res))
                .contactId(res.getContact().getStoreContactId())
                .deliveryCosts(deliveryCosts(res))
                .deliveryLocations(deliveryLocations(res))
                .logoImageId(logoImageId(res))
                .paymentMethods(paymentMethods(res))
                .siteUrl(res.getStoreUrl())
                .storeUrl(res.getSiteUrl())
                .type(typeAsDto(res))
                .workingHours(workingHoursAsDto(res))
                .auth(authAsDto(res))
                .addressId(res.getAddress().getStoreAddressId())
                .about(res.getAbout())
                .build();
    }

    private FoodaStoreAuthDto authAsDto(final FoodaStoreRes res){
        return null;
    }

    private List<FoodaStoreWorkingHoursDto> workingHoursAsDto(final FoodaStoreRes res){
        return null;
    }

    private List<FoodaStorePaymentMethodDto> paymentMethods(FoodaStoreRes res) {
        return null;
    }

    private Long logoImageId(FoodaStoreRes res) {
        return null;
    }

    private List<FoodaStoreDeliveryLocationDto> deliveryLocations(FoodaStoreRes res) {
        return null;
    }

    private List<FoodaStoreDeliveryCostDto> deliveryCosts(FoodaStoreRes res) {
        return null;
    }

    private Long bgVideoId(FoodaStoreRes res) {
        return null;
    }

    private Long bgImageId(FoodaStoreRes res) {
        return null;
    }

}