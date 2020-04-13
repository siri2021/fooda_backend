package it.vkod.woo.product.service.payloads.orderRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WooOrderRequest {

    @JsonProperty("store_id")
    private long storeId;

    @JsonProperty("id")
    private int id;

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public void setShippingLines(List<ShippingLinesItem> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public List<ShippingLinesItem> getShippingLines() {
        return shippingLines;
    }

    public void setSetPaid(boolean setPaid) {
        this.setPaid = setPaid;
    }

    public boolean isSetPaid() {
        return setPaid;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
    }

    public String getPaymentMethodTitle() {
        return paymentMethodTitle;
    }

    public void setLineItems(List<LineItemsItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItemsItem> getLineItems() {
        return lineItems;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Billing getBilling() {
        return billing;
    }

    @Override
    public String toString() {
        return
                "WooOrderRequest{" +
                        "store_id = '" + storeId + '\'' +
                        ",order_id = '" + id + '\'' +
                        ",shipping_lines = '" + shippingLines + '\'' +
                        ",set_paid = '" + setPaid + '\'' +
                        ",shipping = '" + shipping + '\'' +
                        ",payment_method_title = '" + paymentMethodTitle + '\'' +
                        ",line_items = '" + lineItems + '\'' +
                        ",payment_method = '" + paymentMethod + '\'' +
                        ",billing = '" + billing + '\'' +
                        "}";
    }
}