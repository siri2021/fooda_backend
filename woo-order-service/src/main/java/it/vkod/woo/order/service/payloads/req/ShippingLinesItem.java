package it.vkod.woo.order.service.payloads.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShippingLinesItem {
    @Getter
    @Setter
    private String total;
    @Getter
    @Setter
    private String method_id;
    @Getter
    @Setter
    private String method_title;
}
