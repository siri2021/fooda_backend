package it.vkod.woo.product.client.pojo.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
public class OrderResponseLineItemsItem {
    @Getter
    @Setter
    private int quantity;
    @Getter
    @Setter
    private String tax_class;
    @Getter
    @Setter
    private List<OrderResponseTaxesItem> taxes;
    @Getter
    @Setter
    private double total_tax;
    @Getter
    @Setter
    private double total;
    @Getter
    @Setter
    private int variation_id;
    @Getter
    @Setter
    private double subtotal;
    @Getter
    @Setter
    private double price;
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
    private double subtotal_tax;
    @Getter
    @Setter
    private String sku;
}