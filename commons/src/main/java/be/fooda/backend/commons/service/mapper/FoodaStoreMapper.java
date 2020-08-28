package be.fooda.backend.commons.service.mapper;

import be.fooda.backend.commons.dao.repo.FoodaAddressRepository;
import be.fooda.backend.commons.dao.repo.FoodaContactRepository;
import be.fooda.backend.commons.model.template.store.dto.FoodaStoreAuthDto;
import be.fooda.backend.commons.model.template.store.dto.FoodaStoreDto;
import be.fooda.backend.commons.model.template.store.request.*;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreAuthItemRes;
import be.fooda.backend.commons.model.template.store.response.FoodaStoreRes;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FoodaStoreMapper implements FoodaObjectMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> {

    private final FoodaContactRepository contactRepo;
    private final FoodaAddressRepository addressRepo;

    @Override
    public FoodaStoreReq dtoToRequest(FoodaStoreDto dto) {
        return FoodaStoreReq.builder()
                .storeUrl(dto.getStoreUrl())
                .workingHours(workHours(dto))
                .name(dto.getName())
                .logo(logo(dto))
                .slogan(dto.getSlogan())
                .type(type(dto))
                .about(dto.getAbout())
                .deliveryLocations(deliveryLocations(dto))
                .deliveryCosts(deliveryCosts(dto))
                .paymentMethods(paymentMethods(dto))
                .build();
    }

    private List<FoodaStorePaymentMethodsItemReq> paymentMethods(FoodaStoreDto dto) {
        return dto.getPaymentMethods().stream().map(payments -> FoodaStorePaymentMethodsItemReq.builder()
                .minOrderAmount(payments.getMinOrderAmount())
                .build()).collect(Collectors.toList());
    }


    private FoodaStoreTypeReq type(FoodaStoreDto dto) {
        return FoodaStoreTypeReq.builder().title(dto.getType().getTitle()).build();
    }

    private FoodaStoreLogoReq logo(FoodaStoreDto dto) {
        return FoodaStoreLogoReq.builder().url(dto.getSiteUrl()).build();

    }


    private List<FoodaStoreDeliveryLocationsItemReq> deliveryLocations(final FoodaStoreDto dto) {
        dto.getDeliveryLocations().stream().map(loc -> FoodaStoreDeliveryLocationsItemReq.builder()
                //.municipalityId(dto.getMunicipalityId()) // lond municipalId expected but dto has string municipality
                .deliveryTime(loc.getDeliveryTime())
                .deliveryCost(loc.getDeliveryCost())
                .build()).collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryCostsItemReq> deliveryCosts(final FoodaStoreDto dto) {
        return dto.getDeliveryCosts().
                stream()
                .map(costs -> FoodaStoreDeliveryCostsItemReq.builder()
                        .amount(costs.getAmount())
                        .maxPrice(costs.getMaxPrice())
                        .minPrice(costs.getMinPrice())
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
            .name(res.)
            .contact()
            .videos()
            .paymentMethods()
            .images()
            .deliveryCosts()
            .deliveryLocations()
            .about()
            .address()
            .type()
            .slogan()
            .logo()
            .workingHours()
            .storeUrl()
            .siteUrl()
            .auth()
            .storeId().build();


    }

    @Override
    public FoodaStoreRes dtoToResponse(FoodaStoreDto dto) {
        return FoodaStoreRes.builder().
    }

    @Override
    public FoodaStoreRes requestToResponse(FoodaStoreReq req) {
        return FoodaStoreRes.builder().
    }

    @Override
    public FoodaStoreDto requestToDto(FoodaStoreReq req) {
        return FoodaStoreDto.builder()
                .name(req.getName())
                .bgImageId(req.)
                .bgVideoId(req.)
                .contactId(req.getContact())
                .deliveryCosts(deliveryCosts(req))
                .deliveryLocations(deliveryLocarions(req))
                .logoImageId(logo(req))
                .paymentMethods(paymentMethods(req))
                .siteUrl(req.getSiteUrl())
                .storeUrl(req.getStoreUrl())
                .type(type(req))
                .workingHours(workingHours(req))
                .auth(auth(req))
                .about()
                .build()
    }

    @Override
    public FoodaStoreDto responseToDto(FoodaStoreRes res) {
        return FoodaStoreDto.builder()
                .name()
                .bgImageId()
                .bgVideoId()
                .contactId()
                .deliveryCosts()
                .deliveryLocations()
                .logoImageId()
                .paymentMethods()
                .siteUrl()
                .storeUrl()
                .type()
                .workingHours()
                .auth()
                .addressId()
                .about()
                .build()
    }

}