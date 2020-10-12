package be.fooda.backend.commons.model.template.product.response;

import lombok.*;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class FoodaProductRes {
    private Long productId;
    private Boolean isFeatured;
    private List<FoodaProductImagesItemRes> images;
    private String description;
    private List<FoodaProductTaxesItemRes> taxes;
    private FoodaProductStoreRes store;
    private Integer stockQuantity;
    private FoodaProductTypeRes type;
    private List<String> tags;
    private String name;
    private List<String> categories;
    private Integer orderLimit;
    private List<FoodaProductPricesItemRes> prices;
}