package it.vkod.fooda.customer.frontend.models.basket.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class BasketBilling implements Serializable {

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
