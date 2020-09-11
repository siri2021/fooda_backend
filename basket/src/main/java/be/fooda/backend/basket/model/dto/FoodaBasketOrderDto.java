package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ORDER")
public class FoodaBasketOrderDto {
    @Id
    private Long basketOrderId;
    private FoodaBasketKeyDto basketKey;
    private LocalDateTime registryTime;
    private LocalDateTime requiredTime;
    private LocalDateTime expiryTime;
    private String note;

}
