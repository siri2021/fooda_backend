package it.vkod.fooda.product.server.models.order.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class LineItemsItem {
    @Getter
    @Setter
    private int quantity;
    @Getter
    @Setter
    private String tax_class;
    @Getter
    @Setter
    private List<TaxesItem> taxes;
    @Getter
    @Setter
    private String total_tax;
    @Getter
    @Setter
    private String total;
    @Getter
    @Setter
    private int variation_id;
    @Getter
    @Setter
    private String subtotal;
    @Getter
    @Setter
    private int price;
    @Getter
    @Setter
    private int product_id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private List<Object> meta_data;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String subtotal_tax;
    @Getter
    @Setter
    private String sku;
}