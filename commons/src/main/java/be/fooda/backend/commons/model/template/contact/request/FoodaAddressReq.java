package be.fooda.backend.commons.model.template.contact.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaAddressReq { // sending post, put, delete, get request
    private Integer addressId;
    private Integer userId;
    private String doorNo;
    private String number;
    private String street;
    private String municipality;
    private String postcode;
    private String city;
    private String region;
    private String country;
}