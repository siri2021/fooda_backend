package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FoodaStoreImagesItemReq {
    private String title;
    private String url;
}