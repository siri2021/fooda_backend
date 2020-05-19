package it.vkod.woo.product.client.payloads.order.request;

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
    private List<OrderShippingLinesItem> shippingLines;
    @Getter
    @Setter
    private boolean setPaid;
    @Getter
    @Setter
    private OrderShipping shipping;
    @Getter
    @Setter
    private String paymentMethodTitle;
    @Getter
    @Setter
    private List<OrderLineItemsItem> lineItems;
    @Getter
    @Setter
    private String paymentMethod;
    @Getter
    @Setter
    private OrderBilling billing;
}