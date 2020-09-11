package be.fooda.backend.commons.model.template.basket.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketDeliveryReq {
    private Long userId;
    private String session;
    private Long storeId;
    private Long billingAddressId;
    private Long billingContactId;
    private Long deliveryAddressId;
    private Long deliveryContactId;
}
