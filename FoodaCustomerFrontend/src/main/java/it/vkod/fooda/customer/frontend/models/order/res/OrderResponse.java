package it.vkod.fooda.customer.frontend.models.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class OrderResponse {

    @Getter
    @Setter
    @JsonIgnore
    private long store_id;
    @Getter
    @Setter
    private String discount_total;
    @Getter
    @Setter
    private String order_key;
    @Getter
    @Setter
    private boolean prices_include_tax;
    @Getter
    @Setter
    private OrderResponseLinks links;
    @Getter
    @Setter
    private String customer_note;
    @Getter
    @Setter
    private List<OrderResponseLineItemsItem> line_items;
    @Getter
    @Setter
    private List<Object> coupon_lines;
    @Getter
    @Setter
    private OrderResponseBilling billing;
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
    private OrderResponseShipping shipping;
    @Getter
    @Setter
    private String date_paid_gmt;
    @Getter
    @Setter
    private List<OrderResponseTaxLinesItem> tax_lines;
    @Getter
    @Setter
    private String date_paid;
    @Getter
    @Setter
    private String customer_user_agent;
    @Getter
    @Setter
    private String payment_method_title;
    @Getter
    @Setter
    private List<OrderResponseMetaDataItem> meta_data;
    @Getter
    @Setter
    private Object date_completed;
    @Getter
    @Setter
    private String currency;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private Object date_completed_gmt;
    @Getter
    @Setter
    private String payment_method;
    @Getter
    @Setter
    private String shipping_tax;
    @Getter
    @Setter
    private String transaction_id;
    @Getter
    @Setter
    private String date_modified_gmt;
    @Getter
    @Setter
    private String cart_hash;
    @Getter
    @Setter
    private String shipping_total;
    @Getter
    @Setter
    private String cart_tax;
    @Getter
    @Setter
    private String created_via;
    @Getter
    @Setter
    private String date_created;
    @Getter
    @Setter
    private String date_created_gmt;
    @Getter
    @Setter
    private String discount_tax;
    @Getter
    @Setter
    private String total_tax;
    @Getter
    @Setter
    private String version;
    @Getter
    @Setter
    private String customer_ip_address;
    @Getter
    @Setter
    private List<OrderResponseShippingLinesItem> shipping_lines;
    @Getter
    @Setter
    private String date_modified;
    @Getter
    @Setter
    private int parent_id;
    @Getter
    @Setter
    private List<Object> fee_lines;
    @Getter
    @Setter
    private int customer_id;
    @Getter
    @Setter
    private String status;
}