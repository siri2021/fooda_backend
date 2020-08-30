package be.fooda.backend.commons.model.template.basket.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketProductRes {
    private Long basketProductId;
    private Long productId;
    private Long userId;
    private String session;
    private Long storeId;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private String description;
    private Integer quantity;

    public void increase() {
        setQuantity(getQuantity() + 1);
    }

    public void decrease() {
        setQuantity(getQuantity() - 1);
    }

    public void increase(final Integer quantity) {
        setQuantity(getQuantity() + quantity);
    }

    public void decrease(final Integer quantity) {
        setQuantity(getQuantity() - quantity);
    }
}
