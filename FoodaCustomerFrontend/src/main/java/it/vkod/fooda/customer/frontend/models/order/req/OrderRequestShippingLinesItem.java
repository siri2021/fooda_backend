package it.vkod.fooda.customer.frontend.models.order.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder(toBuilder = true)
public class OrderRequestShippingLinesItem {
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
