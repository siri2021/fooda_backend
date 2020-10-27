package be.fooda.backend.commons.model.template.store.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
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
    private String siteUrl;
    private List<FoodaStoreWorkingHoursItemReq> workingHours;
    private FoodaStoreContactReq contact;
    private String name;
    private FoodaStoreLogoReq logo;
    private List<FoodaStoreDeliveryLocationsItemReq> deliveryLocations;
    private String slogan;
}