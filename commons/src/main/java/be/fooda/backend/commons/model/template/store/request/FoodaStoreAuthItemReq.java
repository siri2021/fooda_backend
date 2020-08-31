package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class FoodaStoreAuthItemReq {
    private String secret;
    private LocalDate expiry;
    private String key;
}