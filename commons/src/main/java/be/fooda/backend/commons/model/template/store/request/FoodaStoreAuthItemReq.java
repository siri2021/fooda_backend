package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class FoodaStoreAuthItemReq {
    private String secret;
    private LocalDate expiry;
    private String key;
}