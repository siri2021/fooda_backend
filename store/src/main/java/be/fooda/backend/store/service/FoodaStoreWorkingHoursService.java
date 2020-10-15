package be.fooda.backend.store.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FoodaStoreWorkingHoursService<REQ, RES>{
    List<RES> getByWorkingHours(final LocalDate date, final LocalDateTime opens, final LocalDateTime closes);

    List<RES> getByWorkingHours(final LocalDateTime opens, final LocalDateTime closes);
}
