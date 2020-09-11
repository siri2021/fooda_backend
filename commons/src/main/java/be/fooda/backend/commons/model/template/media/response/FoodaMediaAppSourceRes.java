package be.fooda.backend.commons.model.template.media.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaMediaAppSourceRes {
    private Long appSourceId;
    private String title;
    private String url;
    private String resolution;
    private Boolean mustBeCached;
}
