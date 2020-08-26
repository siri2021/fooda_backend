package be.fooda.backend.commons.model.template.matching.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaMatchRes {
    private Long matchResultId;
    private String keyword;
    private String matched;
    private Double score;
    private FoodaMatchCategoryRes category;
}