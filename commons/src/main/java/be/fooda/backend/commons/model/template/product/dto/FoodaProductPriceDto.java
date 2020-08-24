package be.fooda.backend.commons.model.template.product.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

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
    private String title;
    private BigDecimal amount;
    private LocalDate expiry;
}
