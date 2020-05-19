package it.vkod.woo.order.service.payloads.request;

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
    private List<ShippingLinesItem> shippingLines;
    @Getter
    @Setter
    private boolean setPaid;
    @Getter
    @Setter
    private Shipping shipping;
    @Getter
    @Setter
    private String paymentMethodTitle;
    @Getter
    @Setter
    private List<LineItemsItem> lineItems;
    @Getter
    @Setter
    private String paymentMethod;
    @Getter
    @Setter
    private Billing billing;
}