package it.vkod.woo.core.payloads.order.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.vkod.woo.core.payloads.product.response.Links;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WooOrderResponse {

    @JsonProperty("store_id")
    private long storeId;

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

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public void setDiscountTotal(String discountTotal) {
        this.discountTotal = discountTotal;
    }

    public String getDiscountTotal() {
        return discountTotal;
    }

    public void setOrderKey(String orderKey) {
        this.orderKey = orderKey;
    }

    public String getOrderKey() {
        return orderKey;
    }

    public void setPricesIncludeTax(boolean pricesIncludeTax) {
        this.pricesIncludeTax = pricesIncludeTax;
    }

    public boolean isPricesIncludeTax() {
        return pricesIncludeTax;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Links getLinks() {
        return links;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setLineItems(List<LineItemsItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItemsItem> getLineItems() {
        return lineItems;
    }

    public void setCouponLines(List<Object> couponLines) {
        this.couponLines = couponLines;
    }

    public List<Object> getCouponLines() {
        return couponLines;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setRefunds(List<Object> refunds) {
        this.refunds = refunds;
    }

    public List<Object> getRefunds() {
        return refunds;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setDatePaidGmt(String datePaidGmt) {
        this.datePaidGmt = datePaidGmt;
    }

    public String getDatePaidGmt() {
        return datePaidGmt;
    }

    public void setTaxLines(List<TaxLinesItem> taxLines) {
        this.taxLines = taxLines;
    }

    public List<TaxLinesItem> getTaxLines() {
        return taxLines;
    }

    public void setDatePaid(String datePaid) {
        this.datePaid = datePaid;
    }

    public String getDatePaid() {
        return datePaid;
    }

    public void setCustomerUserAgent(String customerUserAgent) {
        this.customerUserAgent = customerUserAgent;
    }

    public String getCustomerUserAgent() {
        return customerUserAgent;
    }

    public void setPaymentMethodTitle(String paymentMethodTitle) {
        this.paymentMethodTitle = paymentMethodTitle;
    }

    public String getPaymentMethodTitle() {
        return paymentMethodTitle;
    }

    public void setMetaData(List<MetaDataItem> metaData) {
        this.metaData = metaData;
    }

    public List<MetaDataItem> getMetaData() {
        return metaData;
    }

    public void setDateCompleted(Object dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public Object getDateCompleted() {
        return dateCompleted;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDateCompletedGmt(Object dateCompletedGmt) {
        this.dateCompletedGmt = dateCompletedGmt;
    }

    public Object getDateCompletedGmt() {
        return dateCompletedGmt;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setShippingTax(String shippingTax) {
        this.shippingTax = shippingTax;
    }

    public String getShippingTax() {
        return shippingTax;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setDateModifiedGmt(String dateModifiedGmt) {
        this.dateModifiedGmt = dateModifiedGmt;
    }

    public String getDateModifiedGmt() {
        return dateModifiedGmt;
    }

    public void setCartHash(String cartHash) {
        this.cartHash = cartHash;
    }

    public String getCartHash() {
        return cartHash;
    }

    public void setShippingTotal(String shippingTotal) {
        this.shippingTotal = shippingTotal;
    }

    public String getShippingTotal() {
        return shippingTotal;
    }

    public void setCartTax(String cartTax) {
        this.cartTax = cartTax;
    }

    public String getCartTax() {
        return cartTax;
    }

    public void setCreatedVia(String createdVia) {
        this.createdVia = createdVia;
    }

    public String getCreatedVia() {
        return createdVia;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreatedGmt(String dateCreatedGmt) {
        this.dateCreatedGmt = dateCreatedGmt;
    }

    public String getDateCreatedGmt() {
        return dateCreatedGmt;
    }

    public void setDiscountTax(String discountTax) {
        this.discountTax = discountTax;
    }

    public String getDiscountTax() {
        return discountTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setCustomerIpAddress(String customerIpAddress) {
        this.customerIpAddress = customerIpAddress;
    }

    public String getCustomerIpAddress() {
        return customerIpAddress;
    }

    public void setShippingLines(List<ShippingLinesItem> shippingLines) {
        this.shippingLines = shippingLines;
    }

    public List<ShippingLinesItem> getShippingLines() {
        return shippingLines;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setFeeLines(List<Object> feeLines) {
        this.feeLines = feeLines;
    }

    public List<Object> getFeeLines() {
        return feeLines;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return
                "WooOrder{" +
                        "store_id = '" + storeId + '\'' +
                        ",discount_total = '" + discountTotal + '\'' +
                        ",order_key = '" + orderKey + '\'' +
                        ",prices_include_tax = '" + pricesIncludeTax + '\'' +
                        ",_links = '" + links + '\'' +
                        ",customer_note = '" + customerNote + '\'' +
                        ",line_items = '" + lineItems + '\'' +
                        ",coupon_lines = '" + couponLines + '\'' +
                        ",billing = '" + billing + '\'' +
                        ",refunds = '" + refunds + '\'' +
                        ",number = '" + number + '\'' +
                        ",total = '" + total + '\'' +
                        ",shipping = '" + shipping + '\'' +
                        ",date_paid_gmt = '" + datePaidGmt + '\'' +
                        ",tax_lines = '" + taxLines + '\'' +
                        ",date_paid = '" + datePaid + '\'' +
                        ",customer_user_agent = '" + customerUserAgent + '\'' +
                        ",payment_method_title = '" + paymentMethodTitle + '\'' +
                        ",meta_data = '" + metaData + '\'' +
                        ",date_completed = '" + dateCompleted + '\'' +
                        ",currency = '" + currency + '\'' +
                        ",id = '" + id + '\'' +
                        ",date_completed_gmt = '" + dateCompletedGmt + '\'' +
                        ",payment_method = '" + paymentMethod + '\'' +
                        ",shipping_tax = '" + shippingTax + '\'' +
                        ",transaction_id = '" + transactionId + '\'' +
                        ",date_modified_gmt = '" + dateModifiedGmt + '\'' +
                        ",cart_hash = '" + cartHash + '\'' +
                        ",shipping_total = '" + shippingTotal + '\'' +
                        ",cart_tax = '" + cartTax + '\'' +
                        ",created_via = '" + createdVia + '\'' +
                        ",date_created = '" + dateCreated + '\'' +
                        ",date_created_gmt = '" + dateCreatedGmt + '\'' +
                        ",discount_tax = '" + discountTax + '\'' +
                        ",total_tax = '" + totalTax + '\'' +
                        ",version = '" + version + '\'' +
                        ",customer_ip_address = '" + customerIpAddress + '\'' +
                        ",shipping_lines = '" + shippingLines + '\'' +
                        ",date_modified = '" + dateModified + '\'' +
                        ",parent_id = '" + parentId + '\'' +
                        ",fee_lines = '" + feeLines + '\'' +
                        ",customer_id = '" + customerId + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}