package be.fooda.backend.commons.model.template.product.request;

import lombok.*;
import java.util.List;

@Data
@Builder
public class FoodaProductReq {
    private Boolean isFeatured;
    private List<FoodaProductImagesItemReq> images;
    private String description;
    private List<FoodaProductTaxesItemReq> taxes;
    private FoodaProductStoreReq store;
    private Integer stockQuantity;
    private FoodaProductTypeReq type;
    private List<String> tags;
    private Long productId;
    private String name;
    private List<String> categories;
    private Integer orderLimit;
    private List<FoodaProductPricesItemReq> prices;
}