package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

@Data
@Builder
public class FoodaStoreAuthItemReq {
    private String secret;
    private String expiry;
    private String key;
}