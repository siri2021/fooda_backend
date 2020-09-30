package be.fooda.backend.commons.model.template.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderKeyReq {
    private Long userId;
    private Long storeId;
}
