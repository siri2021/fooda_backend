package be.fooda.backend.commons.model.template.store.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaStoreWorkingHoursItemRes {
    private String openTime;
    private String closeTime;
    private String workingDate;
}