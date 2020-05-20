package it.vkod.woo.order.service.payloads.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
public class LineItemsItem {
    @Getter
    @Setter
    private int quantity;
    @Getter
    @Setter
    private String taxClass;
    @Getter
    @Setter
    private List<TaxesItem> taxes;
    @Getter
    @Setter
    private String totalTax;
    @Getter
    @Setter
    private String total;
    @Getter
    @Setter
    private int variationId;
    @Getter
    @Setter
    private String subtotal;
    @Getter
    @Setter
    private int price;
    @Getter
    @Setter
    private int productId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private List<Object> metaData;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String subtotalTax;
    @Getter
    @Setter
    private String sku;
}