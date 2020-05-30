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
    @JsonProperty("shipping_lines")
    private List<OrderShippingLinesItem> shippingLines;
    @Getter
    @Setter
    @JsonProperty("set_paid")
    private boolean setPaid;
    @Getter
    @Setter
    @JsonProperty("shipping")
    private OrderShipping shipping;
    @Getter
    @Setter
    @JsonProperty("payment_method_title")
    private String paymentMethodTitle;
    @Getter
    @Setter
    @JsonProperty("line_items")
    private List<OrderLineItemsItem> lineItems;
    @Getter
    @Setter
    @JsonProperty("payment_method")
    private String paymentMethod;
    @Getter
    @Setter
    @JsonProperty("billing")
    private OrderBilling billing;
}