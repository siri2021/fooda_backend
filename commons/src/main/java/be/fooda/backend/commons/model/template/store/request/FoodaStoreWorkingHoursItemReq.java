package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class FoodaStoreWorkingHoursItemReq {
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private LocalDate workingDate;
}