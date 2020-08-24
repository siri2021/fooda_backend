package be.fooda.backend.commons.model.template.product.request;

import lombok.*;
@Data
@Builder
public class FoodaProductImagesItemReq {
    private Long mediaId;
    private FoodaProductTypeReq type;
    private String url;
    private Boolean isDefault;
}