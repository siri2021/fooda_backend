package be.fooda.backend.commons.model.template.store.response;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Data
@Builder
public class FoodaStoreAuthItemRes {
    private String secret;
    private LocalDate expiry;
    private String key;
}