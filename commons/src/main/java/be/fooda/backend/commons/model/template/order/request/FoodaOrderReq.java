package be.fooda.backend.commons.model.template.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderReq {
    private Long userId;
    private Long storeId;

    private Long orderStatusId;
    private String note;
    private LocalDateTime requiredTime;
    
    private Set<FoodaOrderProductReq> products;

    private Set<Long> payments;

    private Long billingAddressId;
    private Long deliveryAddressId;

    private Long billingContactId;
    private Long deliveryContactId;
}
