package be.fooda.backend.commons.model.template.store.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class FoodaStoreLogoRes {
    private Long mediaId;
    private String url;
}