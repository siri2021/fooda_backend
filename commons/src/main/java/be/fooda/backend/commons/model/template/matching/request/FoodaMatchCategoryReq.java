package be.fooda.backend.commons.model.template.matching.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaMatchCategoryReq {
    private String title;
    private Double weight;
}
