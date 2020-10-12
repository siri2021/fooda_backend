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
public class FoodaProductCategoryDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productCategoryId;
        
    @NotNull
    private String title;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productId")
    private FoodaProductDto product;
}