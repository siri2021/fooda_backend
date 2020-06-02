package it.vkod.woo.product.client.pojo.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class OrderResponseTaxesItem {
    @Getter
    @Setter
    private String total;
    @Getter
    @Setter
    private String subtotal;
    @Getter
    @Setter
    private int id;
}
