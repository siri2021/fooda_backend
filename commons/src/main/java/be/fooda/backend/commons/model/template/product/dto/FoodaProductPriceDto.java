package be.fooda.backend.commons.model.template.product.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "PRODUCT_PRICE")
public class FoodaProductPriceDto extends FoodaAbstractDto {
    private Long priceId;
    private FoodaProductKeyDto productKey;
    @NotNull
    private String title;
    @NotNull
    private BigDecimal amount;
    private LocalDate expiry;
}
