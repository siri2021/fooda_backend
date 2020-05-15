package it.vkod.woo.product.client.payloads.order.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class LineItemsItem {
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
