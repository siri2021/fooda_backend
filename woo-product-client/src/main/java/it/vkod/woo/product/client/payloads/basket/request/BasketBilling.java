package it.vkod.woo.product.client.payloads.basket.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
public class BasketBilling implements Serializable {

    @Getter
    @Setter
    private UUID billingId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String phone;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String postcode;

    @Getter
    @Setter
    private String municipality;

    @Getter
    @Setter
    private boolean doNotCall;

}
