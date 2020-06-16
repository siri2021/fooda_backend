package it.vkod.woo.product.client.pojo.basket.req;

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
    @EqualsAndHashCode.Exclude
    private UUID basketId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private long storeId;

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private String restUrl;

    @Getter
    @Setter
    private long productId;

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private String name;

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private double price;

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private int quantity;

    @Getter
    @Setter
    @EqualsAndHashCode.Exclude
    private String imageUrl;
}
