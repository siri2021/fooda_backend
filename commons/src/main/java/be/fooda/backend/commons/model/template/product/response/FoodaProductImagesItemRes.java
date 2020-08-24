package be.fooda.backend.commons.model.template.product.response;

import lombok.*;
@NoArgsConstructor
@Data
public class FoodaProductImagesItemRes {
    private Long mediaId;
    private FoodaProductTypeRes type;
    private String url;
    private Boolean isDefault;
}