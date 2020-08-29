package be.fooda.backend.basket.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "ORDER")
public class FoodaBasketOrderDto {
    @Id
    private Long orderId;
    private Long userId;
    private String session;
    private Long storeId;
    private LocalDateTime registryTime;
    private LocalDateTime requiredTime;
}
