package be.fooda.backend.store.dao;

import be.fooda.backend.store.model.dto.FoodaStoreDto;
import be.fooda.backend.store.model.dto.FoodaStoreWorkingHoursDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodaStoreWorkingHoursRepository extends JpaRepository<FoodaStoreWorkingHoursDto, Long> {
    @Query("SELECT swh FROM FoodaStoreWorkingHoursDto swh WHERE swh.workingDate = :date AND swh.openTime = :opens AND closeTime =:closes")
    Optional<FoodaStoreWorkingHoursDto> findByWorkingHours(@Param("date") final LocalDate date, @Param("opens") final LocalDateTime opens, @Param("closes") final LocalDateTime closes);

    @Query("SELECT swh FROM FoodaStoreWorkingHoursDto swh WHERE swh.openTime = :opens AND swh.closeTime =:closes")
    Optional<FoodaStoreWorkingHoursDto> findByWorkingHours(@Param("opens") final LocalDateTime opens,@Param("closes") final LocalDateTime closes);
}
