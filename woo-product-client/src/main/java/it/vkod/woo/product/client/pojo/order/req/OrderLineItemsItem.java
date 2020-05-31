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
    @JsonProperty("quantity")
    private int quantity;
    @Getter
    @Setter
    @JsonProperty("variation_id")
    private int variationId;
    @Getter
    @Setter
    @JsonProperty("product_id")
    private int productId;
}
