package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class FoodaStoreAuthItemReq {
    private String secret;
    private String expiry;
    private String key;
}