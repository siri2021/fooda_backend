package it.vkod.fooda.basket.server.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Document(value = "basket_shipping")
public class Shipping implements Serializable {

    @Id
    private UUID shippingId;
    private String userId;
    private String firstName;
    private String lastName;
    private String address;
    private String postcode;
    private String municipality;
}

