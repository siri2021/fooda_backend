package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class FoodaBasketPaymentDto {
    @MongoId(FieldType.OBJECT_ID)
    private String basketPaymentId;
    private FoodaBasketKeyDto basketKey;
    private Long paymentId;
    private BigDecimal amount;
}
