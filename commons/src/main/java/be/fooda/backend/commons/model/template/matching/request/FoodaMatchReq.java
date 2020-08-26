package be.fooda.backend.commons.model.template.matching.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaMatchReq {
    private Long relatedId;
    private String keyword;
    private String matched;
    private Double minScore;
    private FoodaMatchCategoryReq category;
}