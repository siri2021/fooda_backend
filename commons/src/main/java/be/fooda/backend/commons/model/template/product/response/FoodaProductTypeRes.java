package be.fooda.backend.commons.model.template.product.response;

import lombok.*;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class FoodaProductTypeRes {
    private Long typeId;
    private String name;
    private String extension;
    private String title;
}