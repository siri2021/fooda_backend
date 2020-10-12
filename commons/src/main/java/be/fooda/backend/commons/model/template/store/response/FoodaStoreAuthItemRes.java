package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaStoreAuthItemRes {
    private String secret;
    private LocalDate expiry;
    private String key;
}