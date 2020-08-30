package be.fooda.backend.commons.model.template.basket.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketOrderRes {
    private Long basketOrderId;
    private Long userId;
    private String session;
    private Long storeId;
    private LocalDateTime registryTime;
    private LocalDateTime requiredTime;
    private LocalDateTime expiryTime;
    private String note;

}
