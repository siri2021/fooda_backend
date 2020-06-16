package it.vkod.fooda.customer.frontend.models.basket.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class BasketProduct implements Serializable {

    @EqualsAndHashCode.Exclude
    private UUID basketId;
    private String userId;
    private long storeId;
    @EqualsAndHashCode.Exclude
    private String restUrl;
    private long productId;
    @EqualsAndHashCode.Exclude
    private String name;
    @EqualsAndHashCode.Exclude
    private double price;
    @EqualsAndHashCode.Exclude
    private int quantity;
    @EqualsAndHashCode.Exclude
    private String imageUrl;
}
