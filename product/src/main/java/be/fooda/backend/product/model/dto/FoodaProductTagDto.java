package be.fooda.backend.product.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FoodaProductTagDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productTagId;

    @NotNull
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private FoodaProductDto product;
}
