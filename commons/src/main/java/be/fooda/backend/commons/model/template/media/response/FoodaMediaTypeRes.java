package be.fooda.backend.commons.model.template.media.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaMediaTypeRes {
    private Long typeId;
    private String title;
    private String extension;
}
