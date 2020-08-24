package be.fooda.backend.commons.model.template.product.request;

import lombok.*;
@Data
@Builder
public class FoodaProductTaxesItemReq {
    private Double percentage;
    private String title;
    private Long taxId;
    private Boolean isDefault;
}