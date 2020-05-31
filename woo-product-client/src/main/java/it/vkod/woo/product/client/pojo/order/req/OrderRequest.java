package it.vkod.woo.product.client.pojo.order.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
public class OrderRequest {
    @Getter
    @Setter
    private List<OrderShippingLinesItem> shipping_lines;
    @Getter
    @Setter
    private boolean set_paid;
    @Getter
    @Setter
    private OrderShipping shipping;
    @Getter
    @Setter
    private String payment_method_title;
    @Getter
    @Setter
    private List<OrderLineItemsItem> line_items;
    @Getter
    @Setter
    private String payment_method;
    @Getter
    @Setter
    private OrderBilling billing;
}