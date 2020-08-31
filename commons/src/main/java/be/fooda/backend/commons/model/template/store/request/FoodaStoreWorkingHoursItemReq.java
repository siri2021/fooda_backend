package be.fooda.backend.commons.model.template.store.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FoodaStoreWorkingHoursItemReq {
    private LocalTime openTime;
    private LocalTime closeTime;
    private LocalDate workingDate;
}