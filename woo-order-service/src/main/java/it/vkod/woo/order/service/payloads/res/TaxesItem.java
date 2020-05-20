package it.vkod.woo.order.service.payloads.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class TaxesItem {
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
