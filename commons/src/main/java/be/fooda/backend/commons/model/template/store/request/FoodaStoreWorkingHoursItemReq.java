package be.fooda.backend.commons.model.template.store.request;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class FoodaStoreWorkingHoursItemReq {
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private LocalDate workingDate;
}