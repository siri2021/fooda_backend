package be.fooda.backend.basket.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Document(collection = "PRODUCT")
public class FoodaBasketProductDto {
    @Id
    private Long productId;
    private Long userId;
    private String session;
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
