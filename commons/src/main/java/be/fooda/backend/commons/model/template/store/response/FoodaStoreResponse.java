package be.fooda.backend.commons.model.template.store.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class FoodaStoreResponse {

    @JsonProperty("store_id")
    private Integer storeId;

    @JsonProperty("images")
    private List<ImagesItem> images;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("auth")
    private List<AuthItem> auth;

    @JsonProperty("about")
    private String about;

    @JsonProperty("videos")
    private List<VideosItem> videos;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("store_url")
    private String storeUrl;

    @JsonProperty("payment_methods")
    private List<PaymentMethodsItem> paymentMethods;

    @JsonProperty("delivery_costs")
    private List<DeliveryCostsItem> deliveryCosts;

    @JsonProperty("site_url")
    private String siteUrl;

    @JsonProperty("working_hours")
    private List<WorkingHoursItem> workingHours;

    @JsonProperty("contact")
    private Contact contact;

    @JsonProperty("name")
    private String name;

    @JsonProperty("logo")
    private Logo logo;

    @JsonProperty("delivery_locations")
    private List<DeliveryLocationsItem> deliveryLocations;

    @JsonProperty("slogan")
    private String slogan;
}