package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketKeyDto {
    @MongoId(FieldType.OBJECT_ID)
    private String basketKeyId;
    private Long userId;
    private String session;
    private Long storeId;
}
