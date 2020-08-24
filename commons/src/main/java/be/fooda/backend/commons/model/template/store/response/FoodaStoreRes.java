package be.fooda.backend.commons.model.template.store.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@Data
public class FoodaStoreRes {

    @JsonProperty("store_id")
    private Long storeId;

    @JsonProperty("images")
    private List<FoodaStoreImagesItemRes> images;

    @JsonProperty("address")
    private FoodaStoreAddressRes address;

    @JsonProperty("auth")
    private List<FoodaStoreAuthItemRes> auth;

    @JsonProperty("about")
    private String about;

    @JsonProperty("videos")
    private List<FoodaStoreVideosItemRes> videos;

    @JsonProperty("type")
    private FoodaStoreTypeRes type;

    @JsonProperty("store_url")
    private String storeUrl;

    @JsonProperty("payment_methods")
    private List<FoodaStorePaymentMethodsItemRes> paymentMethods;

    @JsonProperty("delivery_costs")
    private List<FoodaStoreDeliveryCostsItemRes> deliveryCosts;

    @JsonProperty("site_url")
    private String siteUrl;

    @JsonProperty("working_hours")
    private List<FoodaStoreWorkingHoursItemRes> workingHours;

    @JsonProperty("contact")
    private FoodaStoreContactRes contact;

    @JsonProperty("name")
    private String name;

    @JsonProperty("logo")
    private FoodaStoreLogoRes logo;

    @JsonProperty("delivery_locations")
    private List<FoodaStoreDeliveryLocationsItemRes> deliveryLocations;

    @JsonProperty("slogan")
    private String slogan;
}