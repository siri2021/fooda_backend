package be.fooda.backend.commons.model.template.store.request;

import lombok.*;
import java.util.List;

@Data
@Builder
public class FoodaStoreReq {
    private Long storeId;
    private List<FoodaStoreImagesItemReq> images;
    private FoodaStoreAddressReq address;
    private List<FoodaStoreAuthItemReq> auth;
    private String about;
    private List<FoodaStoreVideosItemReq> videos;
    private FoodaStoreTypeReq type;
    private String storeUrl;
    private List<FoodaStorePaymentMethodsItemReq> paymentMethods;
    private List<FoodaStoreDeliveryCostsItemReq> deliveryCosts;
    private String siteUrl;
    private List<FoodaStoreWorkingHoursItemReq> workingHours;
    private FoodaStoreContactReq contact;
    private String name;
    private FoodaStoreLogoReq logo;
    private List<FoodaStoreDeliveryLocationsItemReq> deliveryLocations;
    private String slogan;
}