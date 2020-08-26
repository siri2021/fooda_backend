package be.fooda.backend.commons.model.template.store.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaStoreAuthItemRes {
    private String secret;
    private String expiry;
    private String key;
}