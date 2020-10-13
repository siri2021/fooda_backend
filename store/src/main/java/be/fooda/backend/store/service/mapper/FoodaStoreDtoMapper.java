package be.fooda.backend.store.service.mapper;

import be.fooda.backend.commons.model.template.store.request.*;
import be.fooda.backend.commons.model.template.store.response.*;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.*;
import org.mapstruct.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Component
//@Qualifier("FoodaStoreDtoMapper")
public class FoodaStoreDtoMapper implements FoodaDtoMapper<FoodaStoreDto, FoodaStoreReq, FoodaStoreRes> {


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

    private List<FoodaStoreDeliveryLocationsItemReq> deliveryLocationsAsReq(final FoodaStoreDto storedto) {
        return storedto.getDeliveryLocations()
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
                .workingDate(hours.getWorkingDate())
                .closeTime(hours.getCloseTime())
                .openTime(hours.getOpenTime())
                .build()).collect(Collectors.toList());
    }


    @Override
    public FoodaStoreRes dtoToResponse(FoodaStoreDto dto) {
        return FoodaStoreRes.builder()
                .workingHours(workingHoursDtoToRes(dto))
                .about(dto.getAbout())
                .auth(auth(dto))
                .deliveryCosts(deliveryCostsAsRes(dto))
                .deliveryLocations(deliveryLocationsAsRes(dto))
                .logo(logoAsRes(dto))
                .images(images(dto))
                .paymentMethods(paymentMethodsAsRes(dto))
                .build();
    }

    private List<FoodaStoreWorkingHoursItemRes> workingHoursDtoToRes(FoodaStoreDto dto) {
        return dto.getWorkingHours()
                .stream()
                .map(hours -> FoodaStoreWorkingHoursItemRes
                        .builder()
                        .workingDate(hours.getWorkingDate())
                        .openTime(hours.getOpenTime())
                        .closeTime(hours.getCloseTime())
                        .build())
                .collect(Collectors.toList());
    }

    private FoodaStoreLogoRes logoAsRes(FoodaStoreDto dto) {
        return FoodaStoreLogoRes.builder().build(); // need to check with yilmaz if its needed
    }

    private List<FoodaStorePaymentMethodsItemRes> paymentMethodsAsRes(FoodaStoreDto dto) {
        return dto.getPaymentMethods().stream().map(payments -> FoodaStorePaymentMethodsItemRes.builder()
                .expiry(payments.getExpiryDate())
                .minOrderAmount(payments.getMinOrderAmount())
                .build()).collect(Collectors.toList());

    }

    private List<FoodaStoreAuthItemRes> auth(FoodaStoreDto dto) {

        return Arrays.asList(FoodaStoreAuthItemRes.builder().expiry(dto.getAuth()
                .getExpiryDate()).key(dto.getAuth().getKey())
                .secret(dto.getAuth().getSecret()).build());
    }

    private List<FoodaStoreImagesItemRes> images(FoodaStoreDto dto) {
        return List.of(FoodaStoreImagesItemRes.builder().storeImageId(dto.getBgImage().getMediaId()).build(),
                FoodaStoreImagesItemRes.builder().storeImageId(dto.getLogoImage().getMediaId()).build());

    }


    @Override
    public FoodaStoreDto requestToDto(FoodaStoreReq req) {
        return FoodaStoreDto.builder()
                .name(req.getName())
                .bgImage(FoodaStoreMediaDto.builder()
                        .url(req.getImages().get(0).getUrl())
                        .build())
                .bgVideo(FoodaStoreMediaDto.builder()
                        .url(req.getVideos().get(0).getUrl())
                        .build())
                .deliveryCosts(deliveryCostsReqToDto(req))
                .deliveryLocations(deliveryLocationsReqToDto(req))
                .logoImage(FoodaStoreMediaDto.builder()
                        .url(req.getLogo().getUrl())
                        .build())
                .paymentMethods(paymentMethodsReqToDto(req))
                .siteUrl(req.getSiteUrl())
                .storeUrl(req.getStoreUrl())
                .type(typeReqToDto(req))
                .workingHours(workingHoursReqToDto(req))
                .auth(authReqToDto(req))
                .about(req.getAbout())
                .build();
    }


    private List<FoodaStoreDeliveryCostDto> deliveryCostsReqToDto(FoodaStoreReq req) {
        return req.getDeliveryCosts().stream()
                .map(costs -> FoodaStoreDeliveryCostDto.builder()
                        .amount(costs.getAmount())
                        .maxPrice(costs.getMaxPrice())
                        .minPrice(costs.getMinPrice()).build()).collect(Collectors.toList());
    }

    private FoodaStoreAuthDto authReqToDto(FoodaStoreReq req) {
        return req.getAuth().stream().map(auth -> FoodaStoreAuthDto.builder()
                .key(auth.getKey())
                .expiryDate(auth.getExpiry())
                .secret(auth.getSecret())
                .build()).findFirst().get();
    }

    private List<FoodaStoreWorkingHoursDto> workingHoursReqToDto(FoodaStoreReq req) {
        return req.getWorkingHours().stream().map(hours -> FoodaStoreWorkingHoursDto.builder()
                .openTime(hours.getOpenTime())
                .closeTime(hours.getCloseTime())
                .workingDate(hours.getWorkingDate())
                .build()).collect(Collectors.toList());
    }

    private FoodaStoreTypeDto typeReqToDto(FoodaStoreReq req) {

        return FoodaStoreTypeDto.builder().title(req.getType().getTitle()).build();
    }

    private List<FoodaStorePaymentMethodDto> paymentMethodsReqToDto(FoodaStoreReq req) {
        return req.getPaymentMethods().stream()
                .map(payments -> FoodaStorePaymentMethodDto.builder()
                        .expiryDate(payments.getExpiry())
                        .minOrderAmount(payments.getMinOrderAmount()).build()).collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryLocationDto> deliveryLocationsReqToDto(FoodaStoreReq req) {
        return req.getDeliveryLocations().stream().map(locs -> FoodaStoreDeliveryLocationDto
                .builder()
                .deliveryTime(locs.getDeliveryTime())
                .build()).collect(Collectors.toList());

    }


    @Override
    public FoodaStoreDto responseToDto(FoodaStoreRes res) {
        return FoodaStoreDto.builder()
                .name(res.getName())
                .bgImage(FoodaStoreMediaDto.builder()
                        .url(res.getImages().get(0).getUrl())
                        .mediaId(res.getImages().get(0).getStoreImageId())
                        .build())
                .bgVideo(FoodaStoreMediaDto.builder()
                        .url(res.getVideos().get(0).getUrl())
                        .mediaId(res.getVideos().get(0).getMediaId())
                        .build())
                .deliveryCosts(deliveryCosts(res))
                .deliveryLocations(deliveryLocations(res))
                .logoImage(FoodaStoreMediaDto.builder()
                        .url(res.getLogo().getUrl())
                        .mediaId(res.getLogo().getMediaId())
                        .build())
                .paymentMethods(paymentMethods(res))
                .siteUrl(res.getStoreUrl())
                .storeUrl(res.getSiteUrl())
                .type(typeResToDto(res))
                .workingHours(workingHoursAsDto(res))
                .auth(authAsDto(res))
                .address(FoodaStoreAddressDto.builder()
                        .addressId(res.getAddress().getAddressId())
                        .postcode(res.getAddress().getPostcode())
                        .city(res.getAddress().getCity())
                        .municipality(res.getAddress().getMunicipality())
                        .build())
                .about(res.getAbout())
                .build();
    }

    private Long contactResToDto(FoodaStoreRes res) {
        return null;//can it be done,because there is no contact dto
    }

    private FoodaStoreTypeDto typeResToDto(FoodaStoreRes res) {
        return FoodaStoreTypeDto.builder()
                .title(res.getType().getTitle()).build();
    }

    private FoodaStoreAuthDto authAsDto(final FoodaStoreRes res) {

        return res.getAuth().stream().map(auth -> FoodaStoreAuthDto
                .builder()
                .key(auth.getSecret())
                .secret(auth.getSecret())
                .expiryDate(auth.getExpiry())
                .build()).findFirst().get();
    }

    private List<FoodaStoreWorkingHoursDto> workingHoursAsDto(final FoodaStoreRes res) {

        return res.getWorkingHours().stream().map(hours -> FoodaStoreWorkingHoursDto.builder()
                .workingDate(hours.getWorkingDate())
                .openTime(hours.getOpenTime())
                .closeTime(hours.getCloseTime())
                .build()).collect(Collectors.toList());
    }

    private List<FoodaStorePaymentMethodDto> paymentMethods(FoodaStoreRes res) {

        return res.getPaymentMethods().stream()
                .map(payments -> FoodaStorePaymentMethodDto.builder()
                        .expiryDate(payments.getExpiry())
                        .minOrderAmount(payments.getMinOrderAmount()).build()).collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryLocationDto> deliveryLocations(FoodaStoreRes res) {

        return res.getDeliveryLocations().stream().map(locs -> FoodaStoreDeliveryLocationDto.builder()
                .deliveryCost(locs.getDeliveryCost())
                .deliveryTime(locs.getDeliveryTime())
                .build()).collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryCostDto> deliveryCosts(FoodaStoreRes res) {
        return res.getDeliveryCosts().stream()
                .map(costs -> FoodaStoreDeliveryCostDto.builder()
                        .amount(costs.getAmount())
                        .maxPrice(costs.getMaxPrice())
                        .minPrice(costs.getMinPrice()).build()).collect(Collectors.toList());

    }

}






