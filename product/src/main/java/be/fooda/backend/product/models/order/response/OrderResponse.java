package be.fooda.backend.product.models.order.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse implements Serializable {

    @JsonProperty("store_id")
    private BigInteger storeId;

    @JsonProperty("discount_total")
    private String discountTotal;

    @JsonProperty("order_key")
    private String orderKey;

    @JsonProperty("prices_include_tax")
    private boolean pricesIncludeTax;

    @JsonProperty("_links")
    private Links links;

    @JsonProperty("customer_note")
    private String customerNote;

    @JsonProperty("line_items")
    private List<LineItemsItem> lineItems;

    @JsonProperty("coupon_lines")
    private List<Object> couponLines;

    @JsonProperty("billing")
    private Billing billing;

    @JsonProperty("refunds")
    private List<Object> refunds;

    @JsonProperty("number")
    private String number;

    @JsonProperty("total")
    private String total;

    @JsonProperty("shipping")
    private Shipping shipping;

    @JsonProperty("date_paid_gmt")
    private String datePaidGmt;

    @JsonProperty("tax_lines")
    private List<TaxLinesItem> taxLines;

    @JsonProperty("date_paid")
    private String datePaid;

    @JsonProperty("customer_user_agent")
    private String customerUserAgent;

    @JsonProperty("payment_method_title")
    private String paymentMethodTitle;

    @JsonProperty("meta_data")
    private List<MetaDataItem> metaData;

    @JsonProperty("date_completed")
    private Object dateCompleted;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("id")
    private int id;

    @JsonProperty("date_completed_gmt")
    private Object dateCompletedGmt;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("shipping_tax")
    private String shippingTax;

    @JsonProperty("transaction_id")
    private String transactionId;

    @JsonProperty("date_modified_gmt")
    private String dateModifiedGmt;

    @JsonProperty("cart_hash")
    private String cartHash;

    @JsonProperty("shipping_total")
    private String shippingTotal;

    @JsonProperty("cart_tax")
    private String cartTax;

    @JsonProperty("created_via")
    private String createdVia;

    @JsonProperty("date_created")
    private String dateCreated;

    @JsonProperty("date_created_gmt")
    private String dateCreatedGmt;

    @JsonProperty("discount_tax")
    private String discountTax;

    @JsonProperty("total_tax")
    private String totalTax;

    @JsonProperty("version")
    private String version;

    @JsonProperty("customer_ip_address")
    private String customerIpAddress;

    @JsonProperty("shipping_lines")
    private List<ShippingLinesItem> shippingLines;

    @JsonProperty("date_modified")
    private String dateModified;

    @JsonProperty("parent_id")
    private int parentId;

    @JsonProperty("fee_lines")
    private List<Object> feeLines;

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("status")
    private String status;
}