package it.vkod.fooda.customer.frontend.models.basket.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class BasketPayment implements Serializable {

    private UUID paymentId;
    private String userId;
    private long storeId;
    private String method;
    private String title;

}
