package it.vkod.fooda.product.server.models.order.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WooOrderRequest {
    @Getter
    @Setter
    private List<ShippingLinesItem> shipping_lines;
    @Getter
    @Setter
    private boolean set_paid;
    @Getter
    @Setter
    private Shipping shipping;
    @Getter
    @Setter
    private String payment_method_title;
    @Getter
    @Setter
    private List<LineItemsItem> line_items;
    @Getter
    @Setter
    private String payment_method;
    @Getter
    @Setter
    private Billing billing;
}