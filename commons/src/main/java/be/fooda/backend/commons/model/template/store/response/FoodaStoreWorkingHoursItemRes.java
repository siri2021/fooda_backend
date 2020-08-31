package be.fooda.backend.commons.model.template.store.response;


import lombok.*;

import java.time.LocalTime;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Builder
public class FoodaStoreWorkingHoursItemRes {
    private LocalTime openTime;
    private LocalTime closeTime;
    private LocalDate workingDate;
}