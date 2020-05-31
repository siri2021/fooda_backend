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
    private int total;
    @Getter
    @Setter
    @JsonProperty("method_id")
    private String methodId;
    @Getter
    @Setter
    @JsonProperty("method_title")
    private String methodTitle;
}
