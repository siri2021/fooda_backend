package it.vkod.woo.product.client.payloads.basket.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@Builder(toBuilder = true)
@EqualsAndHashCode
public class BasketPayment {

    @Getter
    @Setter
    private UUID paymentId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private long storeId;

    @Getter
    @Setter
    private String method;

    @Getter
    @Setter
    private String title;

}
