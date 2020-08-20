package be.fooda.backend.commons.model.template.store.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "STORE_TYPE")
public class FoodaStorePaymentMethodDto extends FoodaAbstractDto {
    private Long methodId;
    private Double minOrderAmount;
    private LocalDate expiryDate;
}
