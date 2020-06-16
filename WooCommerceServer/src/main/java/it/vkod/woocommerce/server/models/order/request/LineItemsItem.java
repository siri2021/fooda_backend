package it.vkod.woocommerce.server.models.order.request;

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
    private int variation_id;
    @Getter
    @Setter
    private int product_id;
}
