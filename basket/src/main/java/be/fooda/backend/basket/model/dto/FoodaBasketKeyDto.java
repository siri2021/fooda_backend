package be.fooda.backend.basket.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FoodaBasketKeyDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long basketKeyId;
    private Long userId;
    private String session;
    private Long storeId;
}
