package be.fooda.backend.commons.model.template.store.response;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class FoodaStoreRes implements Serializable {
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