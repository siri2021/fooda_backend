package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class FoodaBasketOrderDto {
    @MongoId(FieldType.OBJECT_ID)
    private String basketOrderId;
    private FoodaBasketKeyDto basketKey;
    private LocalDateTime registryTime;
    private LocalDateTime requiredTime;
    private LocalDateTime expiryTime;
    private String note;

}
