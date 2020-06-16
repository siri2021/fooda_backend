package it.vkod.fooda.basket.server.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Document(value = "basket_billing")
public class Billing implements Serializable {

    @Id
    private UUID billingId;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String postcode;
    private String municipality;
    private boolean doNotCall;

}
