package be.fooda.backend.commons.model.template.store.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class FoodaStoreRequest {

    @JsonProperty("store_id")
    private Long storeId;

    @JsonProperty("images")
    private List<ImagesItemReq> images;

    @JsonProperty("address")
    private FoodaStoreAddressReq address;

    @JsonProperty("auth")
    private List<FoodaStoreAuthItemReq> auth;

    @JsonProperty("about")
    private String about;

    @JsonProperty("videos")
    private List<VideosItemReq> videos;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("store_url")
    private String storeUrl;

    @JsonProperty("payment_methods")
    private List<PaymentMethodsItemReq> paymentMethods;

    @JsonProperty("delivery_costs")
    private List<FoodaStoreDeliveryCostsItemReq> deliveryCosts;

    @JsonProperty("site_url")
    private String siteUrl;

    @JsonProperty("working_hours")
    private List<WorkingHoursItem> workingHours;

    @JsonProperty("contact")
    private FoodaStoreContactReq contact;

    @JsonProperty("name")
    private String name;

    @JsonProperty("logo")
    private Logo logo;

    @JsonProperty("delivery_locations")
    private List<DeliveryLocationsItem> deliveryLocations;

    @JsonProperty("slogan")
    private String slogan;
}