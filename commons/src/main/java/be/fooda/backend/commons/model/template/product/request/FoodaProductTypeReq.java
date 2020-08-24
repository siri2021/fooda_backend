package be.fooda.backend.commons.model.template.product.request;

import lombok.*;
@Data
@Builder
public class FoodaProductTypeReq {
    private Long typeId;
    private String title;
}