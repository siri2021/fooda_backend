package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class FoodaBasketDeliveryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basketDeliveryId;
    private FoodaBasketKeyDto basketKey;
    private Long billingAddressId;
    private Long billingContactId;
    private Long deliveryAddressId;
    private Long deliveryContactId;
}
