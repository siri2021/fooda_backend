package be.fooda.backend.commons.model.template.store.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class FoodaStoreAuthItemReq {

    private String secret;
    private LocalDate expiry;
    private String key;
}