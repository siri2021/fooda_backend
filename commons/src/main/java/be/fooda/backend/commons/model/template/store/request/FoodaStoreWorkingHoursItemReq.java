package be.fooda.backend.commons.model.template.store.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class FoodaStoreWorkingHoursItemReq {

    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private LocalDate workingDate;
}