package it.vkod.woo.product.client.pojo.order.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private int variation_id;
    @Getter
    @Setter
    private int product_id;
}
