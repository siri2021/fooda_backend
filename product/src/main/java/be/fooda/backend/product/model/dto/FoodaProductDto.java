package be.fooda.backend.product.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PRODUCT")
public class FoodaProductDto extends FoodaAbstractDto {
    @EmbeddedId
    private FoodaProductKeyDto key;
    @NotNull
    private String name;
    private String description;
    private Integer limit;
    @NotNull
    @OneToOne
    private FoodaProductPriceDto price;
    private Boolean isFeatured;
    @OneToOne
    private FoodaProductTypeDto type;
    @OneToOne
    private FoodaProductTaxDto tax;
    private Long imageId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodaProductCategoryDto> categories;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodaProductTagDto> tags;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodaProductIngredientDto> ingredients;
}
