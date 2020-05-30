package it.vkod.woo.order.service.payloads.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class WooOrderRequest {
    @Getter
    @Setter
    @JsonProperty("shipping_lines")
    private List<ShippingLinesItem> shippingLines;
    @Getter
    @Setter
    @JsonProperty("set_paid")
    private boolean setPaid;
    @Getter
    @Setter
    @JsonProperty("shipping")
    private Shipping shipping;
    @Getter
    @Setter
    @JsonProperty("payment_method_title")
    private String paymentMethodTitle;
    @Getter
    @Setter
    @JsonProperty("line_items")
    private List<LineItemsItem> lineItems;
    @Getter
    @Setter
    @JsonProperty("payment_method")
    private String paymentMethod;
    @Getter
    @Setter
    @JsonProperty("billing")
    private Billing billing;
}