package it.vkod.woo.order.service.payloads.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String method_id;
    @Getter
    @Setter
    private String method_title;
}
