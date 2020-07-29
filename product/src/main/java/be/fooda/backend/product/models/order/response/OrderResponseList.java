package be.fooda.backend.product.models.order.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonAutoDetect
public class OrderResponseList extends ArrayList<OrderResponse> {

}
