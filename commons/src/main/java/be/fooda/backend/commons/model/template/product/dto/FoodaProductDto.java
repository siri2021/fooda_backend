package be.fooda.backend.commons.model.template.product.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "PRODUCT")
public class FoodaProductDto extends FoodaAbstractDto {
    @EmbeddedId
    private FoodaProductKeyDto key;
    private String name;
    private String description;
    private Integer limit;
    private FoodaProductPriceDto price;
    private Boolean isFeatured;
    private FoodaProductTypeDto type;
    private FoodaProductTaxDto tax;
    private Long imageId;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodaProductCategoryDto> categories;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodaProductTagDto> tags;
    @OneToMany(cascade = CascadeType.ALL)
    private List<FoodaProductIngredientDto> ingredients;
}
