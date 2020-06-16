package it.vkod.woo.product.client.pojo.order.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
    private List<OrderRequestShippingLinesItem> shipping_lines;
    @Getter
    @Setter
    private boolean set_paid;
    @Getter
    @Setter
    private OrderRequestShipping shipping;
    @Getter
    @Setter
    private String payment_method_title;
    @Getter
    @Setter
    private List<OrderRequestLineItemsItem> line_items;
    @Getter
    @Setter
    private String payment_method;
    @Getter
    @Setter
    private OrderRequestBilling billing;
}