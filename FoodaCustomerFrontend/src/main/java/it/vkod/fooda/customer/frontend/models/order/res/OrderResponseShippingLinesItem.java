package it.vkod.fooda.customer.frontend.models.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
public class OrderResponseShippingLinesItem {
    @Getter
    @Setter
    private String total;
    @Getter
    @Setter
    private String method_id;
    @Getter
    @Setter
    private List<Object> meta_data;
    @Getter
    @Setter
    private List<Object> taxes;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String total_tax;
    @Getter
    @Setter
    private String method_title;
}