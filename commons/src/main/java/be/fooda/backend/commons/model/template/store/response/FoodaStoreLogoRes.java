package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaStoreLogoRes {
    private Long mediaId;
    private String url;
}