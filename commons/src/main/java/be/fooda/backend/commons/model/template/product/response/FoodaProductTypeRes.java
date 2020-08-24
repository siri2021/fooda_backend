package be.fooda.backend.commons.model.template.product.response;

import lombok.*;
@NoArgsConstructor
@Data
public class FoodaProductTypeRes {
    private Long typeId;
    private String name;
    private String extension;
    private String title;
}