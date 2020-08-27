package be.fooda.backend.commons.model.template.matching.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FoodaMatchItemRes implements java.io.Serializable {
    private Long matchId;
    private String keyword;
    private String matched;
    private Double weight;
    private Double score;
    private Object relatedObject;
}
