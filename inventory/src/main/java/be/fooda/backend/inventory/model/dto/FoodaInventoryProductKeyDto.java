package be.fooda.backend.inventory.model.dto;

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
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class FoodaInventoryProductKeyDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productKeyId;
    private Long productId;
    private Long storeId;
}
