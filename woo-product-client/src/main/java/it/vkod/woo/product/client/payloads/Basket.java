package it.vkod.woo.product.client.payloads;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@JsonAutoDetect
public class Basket implements Serializable {

    @Getter
    @Setter
    private UUID basketId;

    @Getter
    @Setter
    private UUID userId;

    @Getter
    @Setter
    private long storeId;

    @Getter
    @Setter
    private long productId;

    @Getter
    @Setter
    private int quantity;
}
