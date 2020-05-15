package it.vkod.woo.product.service.payloads.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class ShippingLinesItem {
    @Getter
    @Setter
    private int total;
    @Getter
    @Setter
    private String methodId;
    @Getter
    @Setter
    private String methodTitle;
}
