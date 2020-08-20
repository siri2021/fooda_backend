package be.fooda.backend.commons.model.template.product.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "PRODUCT_CATEGORY")
public class FoodaProductCategoryDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private FoodaProductKeyDto productKey;

    private String title;
}
