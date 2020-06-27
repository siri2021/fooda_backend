package it.vkod.fooda.customer.frontend.models.basket.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketPayment implements Serializable {

    private UUID id;
    private String userId;
    private Long storeId;
    private String method;
    private String title;

}
