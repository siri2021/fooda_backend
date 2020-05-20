package it.vkod.woo.product.client.pojo.order.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class OrderShippingLinesItem {
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
