package be.fooda.backend.store.model.dto;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreWorkingHoursDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate workingDate;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime openTime;
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime closeTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private FoodaStoreDto store;
}
