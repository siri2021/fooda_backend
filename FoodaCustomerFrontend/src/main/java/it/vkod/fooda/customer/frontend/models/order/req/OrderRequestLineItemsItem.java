package it.vkod.fooda.customer.frontend.models.order.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderRequestLineItemsItem {
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
