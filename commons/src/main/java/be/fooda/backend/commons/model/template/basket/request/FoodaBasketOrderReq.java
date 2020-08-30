package be.fooda.backend.commons.model.template.basket.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketOrderReq {
    private Long userId;
    private String session;
    private Long storeId;
    private LocalDateTime requiredTime;
    private String note;
}
