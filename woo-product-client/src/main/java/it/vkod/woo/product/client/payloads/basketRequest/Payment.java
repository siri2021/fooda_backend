package it.vkod.woo.product.client.payloads.basketRequest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@Builder(toBuilder = true)
@EqualsAndHashCode
public class Payment {

    @Getter
    @Setter
    private UUID paymentId;

    @Getter
    @Setter
    private long userId;

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
