package be.fooda.backend.commons.model.template.matching.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaMatchCategoryRes {
    private Integer categoryId;
    private String title;
    private Double weight;
}
