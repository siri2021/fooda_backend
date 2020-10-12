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
public class FoodaProductDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    private Long externalProductId;

    private Long storeId;

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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FoodaProductCategoryDto> categories;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FoodaProductTagDto> tags;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FoodaProductIngredientDto> ingredients;

   public static FoodaProductDtoBuilder build(){
       return new FoodaProductDtoBuilder(
           @Override
           public FoodaProductDtoBuilder price(final FoodaProductPriceDto price){
                price.setProduct
           }
       );
   }
}