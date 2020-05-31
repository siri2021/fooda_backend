package it.vkod.woo.product.client.pojo.order.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class OrderShippingLinesItem {
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
