package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class FoodaBasketDeliveryDto {
    @MongoId(FieldType.OBJECT_ID)
    private String basketDeliveryId;
    private FoodaBasketKeyDto basketKey;
    private Long billingAddressId;
    private Long billingContactId;
    private Long deliveryAddressId;
    private Long deliveryContactId;
}
