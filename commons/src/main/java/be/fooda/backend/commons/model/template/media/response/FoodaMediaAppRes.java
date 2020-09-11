package be.fooda.backend.commons.model.template.media.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaMediaAppRes {
    private Long appSourceMediaId;
    private FoodaMediaAppSourceRes appSource;
    private FoodaMediaTypeRes type;
    private String url;
}