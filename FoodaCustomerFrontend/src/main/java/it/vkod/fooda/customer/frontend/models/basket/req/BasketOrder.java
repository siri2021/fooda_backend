package it.vkod.fooda.customer.frontend.models.basket.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@NoArgsConstructor
@AllArgsConstructor
public class BasketOrder implements Serializable {
    private UUID id;
    private long orderId;
    private BasketAddress deliveryAddress;
    private BasketAddress billingAddress;
    private BasketPayment payment;
    private List<BasketProduct> products;
}
