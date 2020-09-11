package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PAYMENT")
public class FoodaBasketPaymentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basketPaymentId;
    private FoodaBasketKeyDto basketKey;
    private Long paymentId;
    private BigDecimal amount;
}
