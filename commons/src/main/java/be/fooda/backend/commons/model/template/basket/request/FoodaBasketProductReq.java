package be.fooda.backend.commons.model.template.basket.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketProductReq {
    @NotNull
    private Long productId;
    @NotNull
    private Long userId;
    @NotNull
    private String session;
    @NotNull
    private Long storeId;
    @NotNull
    private String name;
    private String imageUrl;
    @NotNull
    private BigDecimal price;
    private String description;
    @Min(value = 0)
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
