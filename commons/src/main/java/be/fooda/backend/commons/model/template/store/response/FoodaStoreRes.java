package be.fooda.backend.commons.model.template.store.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
@Builder
public class FoodaStoreRes {
    private Long storeId;
    private List<FoodaStoreImagesItemRes> images;
    private FoodaStoreAddressRes address;
    private List<FoodaStoreAuthItemRes> auth;
    private String about;
    private List<FoodaStoreVideosItemRes> videos;
    private FoodaStoreTypeRes type;
    private String storeUrl;
    private List<FoodaStorePaymentMethodsItemRes> paymentMethods;
    private List<FoodaStoreDeliveryCostsItemRes> deliveryCosts;
    private String siteUrl;
    private List<FoodaStoreWorkingHoursItemRes> workingHours;
    private FoodaStoreContactRes contact;
    private String name;
    private FoodaStoreLogoRes logo;
    private List<FoodaStoreDeliveryLocationsItemRes> deliveryLocations;
    private String slogan;
}