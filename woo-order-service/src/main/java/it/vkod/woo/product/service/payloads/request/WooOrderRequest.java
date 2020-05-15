package it.vkod.woo.product.service.payloads.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
public class WooOrderRequest {

    @Getter
    @Setter
    private String discountTotal;
    @Getter
    @Setter
    private String orderKey;
    @Getter
    @Setter
    private boolean pricesIncludeTax;
    @Getter
    @Setter
    private Links links;
    @Getter
    @Setter
    private String customerNote;
    @Getter
    @Setter
    private List<LineItemsItem> lineItems;
    @Getter
    @Setter
    private List<Object> couponLines;
    @Getter
    @Setter
    private Billing billing;
    @Getter
    @Setter
    private List<Object> refunds;
    @Getter
    @Setter
    private String number;
    @Getter
    @Setter
    private String total;
    @Getter
    @Setter
    private Shipping shipping;
    @Getter
    @Setter
    private String datePaidGmt;
    @Getter
    @Setter
    private List<TaxLinesItem> taxLines;
    @Getter
    @Setter
    private String datePaid;
    @Getter
    @Setter
    private String customerUserAgent;
    @Getter
    @Setter
    private String paymentMethodTitle;
    @Getter
    @Setter
    private List<MetaDataItem> metaData;
    @Getter
    @Setter
    private Object dateCompleted;
    @Getter
    @Setter
    private String currency;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private Object dateCompletedGmt;
    @Getter
    @Setter
    private String paymentMethod;
    @Getter
    @Setter
    private String shippingTax;
    @Getter
    @Setter
    private String transactionId;
    @Getter
    @Setter
    private String dateModifiedGmt;
    @Getter
    @Setter
    private String cartHash;
    @Getter
    @Setter
    private String shippingTotal;
    @Getter
    @Setter
    private String cartTax;
    @Getter
    @Setter
    private String createdVia;
    @Getter
    @Setter
    private String dateCreated;
    @Getter
    @Setter
    private String dateCreatedGmt;
    @Getter
    @Setter
    private String discountTax;
    @Getter
    @Setter
    private String totalTax;
    @Getter
    @Setter
    private String version;
    @Getter
    @Setter
    private String customerIpAddress;
    @Getter
    @Setter
    private List<ShippingLinesItem> shippingLines;
    @Getter
    @Setter
    private String dateModified;
    @Getter
    @Setter
    private int parentId;
    @Getter
    @Setter
    private List<Object> feeLines;
    @Getter
    @Setter
    private int customerId;
    @Getter
    @Setter
    private String status;
}