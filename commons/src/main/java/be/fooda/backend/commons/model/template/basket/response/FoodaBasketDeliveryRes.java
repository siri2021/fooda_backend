package be.fooda.backend.commons.model.template.basket.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketDeliveryRes {
    private Long basketDeliveryId;
    private FoodaBasketUserRes user;
    private String session;
    private FoodaBasketStoreRes store;
    private FoodaBasketAddressRes billingAddress;
    private FoodaBasketContactRes billingContact;
    private FoodaBasketAddressRes deliveryAddress;
    private FoodaBasketContactRes deliveryContact;
}
