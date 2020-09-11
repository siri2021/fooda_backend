package be.fooda.backend.commons.model.template.media.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaMediaStoreRes {
    private Long storeMediaId;
    private FoodaMediaStoreInfoRes store;
    private FoodaMediaTypeRes type;
    private String url;
}