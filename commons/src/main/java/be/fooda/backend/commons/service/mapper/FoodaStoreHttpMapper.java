package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreReq;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import be.fooda.backend.commons.model.template.store.request.*;
import be.fooda.backend.commons.model.template.store.response.*;
import java.util.List;
import java.util.stream.Collectors;

public class FoodaStoreHttpMapper implements FoodaHttpMapper<FoodaStoreReq, FoodaStoreRes> {
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
        return FoodaStoreContactReq.builder()
                .call("true")
                .phoneNumber(res.getContact().getPhoneNumber())
                .email(res.getContact().getEmail())
                .firstName(res.getContact().getFirstName())
                .familyName(res.getContact().getFamilyName())
                .build();
    }

    private List<FoodaStoreVideosItemReq> videos(FoodaStoreRes res) {

        res.setAbout("safabuhjfba");
        return res.getVideos().stream()
                .map(videos -> FoodaStoreVideosItemReq.builder()
                        .url(videos.getUrl())
                        .title(videos.getTitle())
                        .build()).collect(Collectors.toList());
    }


    @Override
    public FoodaStoreRes requestToResponse(FoodaStoreReq req) {
        return FoodaStoreRes.builder()
                .name(req.getName())
                .storeId(req.getStoreId())
                .images(imagesReqToRes(req))
                .paymentMethods(paymentMethodsReqToRes(req))
                .logo(logoReqToRes(req))
                .deliveryCosts(deliveryCostsReqRes(req))
                .deliveryLocations(deliveyLocation(req))
                .auth(authReqToRes(req))
                .siteUrl(req.getSiteUrl())
                //  .storeUrl(req.getStoreId())
                .slogan(req.getSlogan())
                .build();
    }


    private List<FoodaStoreAuthItemRes> authReqToRes(FoodaStoreReq req) {
        return req.getAuth().stream().map(auth -> FoodaStoreAuthItemRes.builder()
                .secret(auth.getSecret()).key(auth.getKey())
                .expiry(auth.getExpiry()).build()).collect(Collectors.toList());

    }

    private List<FoodaStoreDeliveryLocationsItemRes> deliveyLocation(FoodaStoreReq req) {
        return req.getDeliveryLocations().stream().map(locs -> FoodaStoreDeliveryLocationsItemRes
                .builder()
                .region(locs.getRegion())
                .municipality(locs.getMunicipality())
                .deliveryTime(locs.getDeliveryTime())
                .deliveryCost(locs.getDeliveryCost())
                .city(locs.getCity())
                .country(locs.getCountry())
                .build()).collect(Collectors.toList());

    }

    private List<FoodaStoreDeliveryCostsItemRes> deliveryCostsReqRes(FoodaStoreReq req) {
        return req.getDeliveryCosts().stream().map(costs -> FoodaStoreDeliveryCostsItemRes
                .builder()
                .amount(costs.getAmount())
                .maxPrice(costs.getMaxPrice())
                .minPrice(costs.getMinPrice())
                .build()).collect(Collectors.toList());
    }

    private FoodaStoreLogoRes logoReqToRes(FoodaStoreReq req) {
        return FoodaStoreLogoRes.builder()
                .url(req.getStoreUrl())
                .build();
    }


    private List<FoodaStoreImagesItemRes> imagesReqToRes(FoodaStoreReq req) {

        return req.getImages().stream().map(images -> FoodaStoreImagesItemRes
                .builder()
                .url(images.getUrl())
                .title(images.getTitle())
                .build()).collect(Collectors.toList());
    }

    private List<FoodaStorePaymentMethodsItemRes> paymentMethodsReqToRes(FoodaStoreReq req) {
        return req.getPaymentMethods().stream().map(payments -> FoodaStorePaymentMethodsItemRes
                .builder()
                .title(payments.getTitle())
                .minOrderAmount(payments.getMinOrderAmount())
                .expiry(payments.getExpiry()).build()).collect(Collectors.toList());
    }
}