package it.vkod.woo.product.client.payloads.order.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderLineItemsItem {
    @Getter
    @Setter
    private int quantity;
    @Getter
    @Setter
    private int variationId;
    @Getter
    @Setter
    private int productId;
}
