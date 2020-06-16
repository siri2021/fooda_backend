package it.vkod.woo.product.client.pojo.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
public class OrderResponseTaxLinesItem {
    @Getter
    @Setter
    private String tax_total;
    @Getter
    @Setter
    private int rate_id;
    @Getter
    @Setter
    private List<Object> meta_data;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String label;
    @Getter
    @Setter
    private String rate_code;
    @Getter
    @Setter
    private boolean compound;
    @Getter
    @Setter
    private String shipping_tax_total;
}