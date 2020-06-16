package it.vkod.fooda.customer.frontend.models.basket.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class BasketShipping implements Serializable {

    private UUID shippingId;
    private String userId;
    private String firstName;
    private String lastName;
    private String address;
    private String postcode;
    private String municipality;
}
