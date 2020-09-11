package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PRODUCT")
public class FoodaBasketProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basketProductId;
    private Long productId;
    private FoodaBasketKeyDto key;
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
