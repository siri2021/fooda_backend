package it.vkod.woo.order.service.payloads.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
public class ShippingLinesItem {
    @Getter
    @Setter
    private String total;
    @Getter
    @Setter
    private String methodId;
    @Getter
    @Setter
    private List<Object> metaData;
    @Getter
    @Setter
    private List<Object> taxes;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String totalTax;
    @Getter
    @Setter
    private String methodTitle;
}