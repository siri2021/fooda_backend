package be.fooda.backend.commons.model.template.store.request;

import lombok.*;
@Data
@Builder
public class FoodaStoreVideosItemReq {
    private String title;
    private String url;
}