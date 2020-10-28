package be.fooda.backend.store.service.mapper;

import be.fooda.backend.commons.model.template.store.request.*;
import be.fooda.backend.commons.model.template.store.response.*;
import be.fooda.backend.commons.service.mapper.FoodaDtoMapper;
import be.fooda.backend.store.model.dto.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Primary
@Component
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
                .paymentMethods(paymentMethodsAsReq(dto))
                .build();
    }


    private List<FoodaStorePaymentMethodsItemReq> paymentMethodsAsReq(FoodaStoreDto dto) {
        return dto.getPaymentMethods()
                .stream()
                .map(payments -> FoodaStorePaymentMethodsItemReq.builder()
                        .minOrderAmount(payments.getMinOrderAmount())
                        .build())
                .collect(Collectors.toList());
    }


    private FoodaStoreTypeReq type(FoodaStoreDto dto) {
        return FoodaStoreTypeReq.builder()
                .title(dto.getType())
                .build();
    }

    private FoodaStoreLogoReq logoAsReq(FoodaStoreDto dto) {
        return FoodaStoreLogoReq.builder()
                .url(dto.getSiteUrl())
                .build();

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
                .deliveryLocations(deliveryLocationsAsRes(dto))
                .logo(logoAsRes(dto))
                .images(images(dto))
                .paymentMethods(paymentMethodsAsRes(dto))
                .address(addressDtoToRes(dto))
                .contact(contactDtoToRes(dto))
                .siteUrl(dto.getSiteUrl())
                .slogan(dto.getSlogan())
                .storeUrl(dto.getStoreUrl())
                .build();
    }

    private FoodaStoreContactRes contactDtoToRes(FoodaStoreDto dto) {
        return FoodaStoreContactRes.builder()
                .contactId(dto.getContact().getContactId())
                .firstName(dto.getContact().getFirstName())
                .familyName(dto.getContact().getLastName())
                .phoneNumber(dto.getContact().getPhone())
                .email(dto.getContact().getEmail())
                .build();
    }

    private FoodaStoreAddressRes addressDtoToRes(FoodaStoreDto dto) {
        return FoodaStoreAddressRes.builder()
                .addressId(dto.getAddress().getAddressId())
                .postcode(dto.getAddress().getPostcode())
                .municipality(dto.getAddress().getMunicipality())
                .city(dto.getAddress().getCity())
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
        return FoodaStoreLogoRes.builder()
                .mediaId(dto.getLogoImage().getMediaId())
                .url(dto.getLogoImage().getUrl())
                .build();
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
                .about(req.getAbout())
                .address(adressReqToDto(req))
                .auth(authReqToDto(req))
                .contact(contactReqToDto(req))
                .deliveryLocations(deliveryLocationsReqToDto(req))
                .bgImage(bgImageAsDto(req))
                .logoImage(logoImageAsDto(req))
                .name(req.getName())
                .paymentMethods(paymentMethodsReqToDto(req))
                .siteUrl(req.getSiteUrl())
                .slogan(req.getSlogan())
                .storeUrl(req.getStoreUrl())
                .type(req.getType().getTitle())
                .bgVideo(bgVideoAsDto(req))
                .workingHours(workingHoursReqToDto(req))
                .build();
    }


    private FoodaStoreMediaDto bgImageAsDto(FoodaStoreReq req) {
        return FoodaStoreMediaDto.builder()
                .url(req.getImages().get(0).getUrl())
                .build();
    }

    private FoodaStoreMediaDto bgVideoAsDto(FoodaStoreReq req) {
        return FoodaStoreMediaDto.builder()
                .url(req.getVideos().get(0).getUrl())
                .build();
    }

    private FoodaStoreMediaDto logoImageAsDto(FoodaStoreReq req) {
        return FoodaStoreMediaDto.builder()
                .url(req.getLogo().getUrl())
                .build();
    }

    private FoodaStoreAddressDto adressReqToDto(FoodaStoreReq req) {
        return FoodaStoreAddressDto
                .builder()
                .addressId(req.getAddress().getAddressId())
                .postcode(req.getAddress().getPostcode())
                .municipality(req.getAddress().getMunicipality())
                .city(req.getAddress().getCity())
                .build();
    }

    private FoodaStoreContactDto contactReqToDto(FoodaStoreReq req) {
        return FoodaStoreContactDto.builder()
                .contactId(req.getContact().getContactId())
                .firstName(req.getContact().getFirstName())
                .lastName(req.getContact().getFamilyName())
                .phone(req.getContact().getPhoneNumber())
                .email(req.getContact().getEmail())
                .build();
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

    private List<FoodaStorePaymentMethodDto> paymentMethodsReqToDto(FoodaStoreReq req) {
        return req.getPaymentMethods().stream()
                .map(payments -> FoodaStorePaymentMethodDto.builder()
                        .paymentMethodId(payments.getPaymentMethodId())
                        .expiryDate(payments.getExpiry())
                        .minOrderAmount(payments.getMinOrderAmount())
                        .build())
                .collect(Collectors.toList());
    }

    private List<FoodaStoreDeliveryLocationDto> deliveryLocationsReqToDto(FoodaStoreReq req) {
        return req.getDeliveryLocations().stream().map(locs -> FoodaStoreDeliveryLocationDto
                .builder()
                .deliveryTime(locs.getDeliveryTime())
                .deliveryCost(locs.getDeliveryCost())
                .municipalityId(locs.getMunicipalityId())
                .minOrderPrice(locs.getMinOrderPrice())
                .maxOrderPrice(locs.getMaxOrderPrice())
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
                .deliveryLocations(deliveryLocations(res))
                .logoImage(FoodaStoreMediaDto.builder()
                        .url(res.getLogo().getUrl())
                        .mediaId(res.getLogo().getMediaId())
                        .build())
                .paymentMethods(paymentMethods(res))
                .siteUrl(res.getStoreUrl())
                .storeUrl(res.getSiteUrl())
                .type(res.getType().getTitle())
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
        return null;
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

}






