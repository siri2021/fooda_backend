package be.fooda.backend.product.models.order.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder
public class OrderRequest implements Serializable {

    @JsonProperty("store_id")
    private BigInteger storeId;

    @JsonProperty("shipping_lines")
    private List<ShippingLinesItem> shippingLines;

    @JsonProperty("set_paid")
    private boolean setPaid;

    @JsonProperty("shipping")
    private Shipping shipping;

    @JsonProperty("payment_method_title")
    private String paymentMethodTitle;

    @JsonProperty("line_items")
    private List<LineItemsItem> lineItems;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("billing")
    private Billing billing;
}