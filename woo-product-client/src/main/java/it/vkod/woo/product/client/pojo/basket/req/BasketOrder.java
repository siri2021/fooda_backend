package it.vkod.woo.product.client.pojo.basket.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
@ToString
@JsonAutoDetect
public class BasketOrder implements Serializable {

    @Getter
    @Setter
    private UUID basketId;

    @Getter
    @Setter
    private long orderId;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private long storeId;

}
