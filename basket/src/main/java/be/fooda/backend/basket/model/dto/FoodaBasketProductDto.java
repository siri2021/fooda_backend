package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class FoodaBasketProductDto {
    @MongoId(FieldType.OBJECT_ID)
    private String basketProductId;
    @NotNull
    private Long productId;
    @NotNull
    private FoodaBasketKeyDto key;
    @NotNull
    private String name;
    private String imageUrl;
    @NotNull
    private BigDecimal price;
    private String description;
    @Min(value = 0)
    @NotNull
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
