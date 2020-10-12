package be.fooda.backend.commons.model.template.store.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaStoreWorkingHoursItemRes {
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private LocalDate workingDate;
}