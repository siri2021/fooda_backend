package it.vkod.fooda.customer.frontend.models.basket.req;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
public class BasketAddress implements Serializable {

    private UUID id;
    private String userId;
    private String firstName;
    private String lastName;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private String municipality;
    private String city;
    private String region;
    private String country;
    private Boolean billing;
    private Boolean shipping;
}
