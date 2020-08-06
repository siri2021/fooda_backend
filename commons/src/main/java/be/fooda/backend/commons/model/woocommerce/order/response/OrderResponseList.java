package be.fooda.backend.commons.model.woocommerce.order.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonAutoDetect
public class OrderResponseList extends ArrayList<OrderResponse> {

}
