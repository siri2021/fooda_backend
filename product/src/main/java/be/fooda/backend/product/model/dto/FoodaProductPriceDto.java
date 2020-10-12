package be.fooda.backend.product.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FoodaProductPriceDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productPriceId;

    @NotNull
    private Long productId;

    @NotNull
    private String title;

    @NotNull
    private BigDecimal amount;

    @Column(columnDefinition = "DATE")
    private LocalDate expiry;
}