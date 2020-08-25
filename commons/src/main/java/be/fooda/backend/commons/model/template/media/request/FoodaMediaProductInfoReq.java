package be.fooda.backend.commons.model.template.media.request;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaMediaProductInfoReq {
    private Long productId;
    private String name;
}
