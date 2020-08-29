package be.fooda.backend.basket.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "PAYMENT")
public class FoodaBasketPaymentDto {
    @Id
    private Long paymentId;
    private Long userId;
    private String code;
    private String method;
    private Double amount;
}
