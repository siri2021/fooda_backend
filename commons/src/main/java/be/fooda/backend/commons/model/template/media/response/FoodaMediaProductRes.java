package be.fooda.backend.commons.model.template.media.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaMediaProductRes {
    private Long productMediaId;
    private FoodaMediaStoreRes store;
    private FoodaMediaProductInfoRes product;
    private FoodaMediaTypeRes type;
    private String url;
}