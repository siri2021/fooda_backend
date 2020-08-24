package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

@Data
@Builder
public class FoodaStoreImagesItemReq {
    private String title;
    private String url;
}