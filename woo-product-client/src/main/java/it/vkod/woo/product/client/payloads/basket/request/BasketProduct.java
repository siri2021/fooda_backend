package it.vkod.woo.product.client.payloads.basket.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
@EqualsAndHashCode
@JsonAutoDetect
public class BasketProduct implements Serializable {

    @Getter
    @Setter
    private UUID basketId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private long storeId;

    @Getter
    @Setter
    private String restUrl;

    @Getter
    @Setter
    private long productId;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private double price;

    @Getter
    @Setter
    private int quantity;

    @Getter
    @Setter
    private String imageUrl;
}
