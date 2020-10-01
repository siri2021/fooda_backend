package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class FoodaStoreWorkingHoursDto extends FoodaAbstractDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeWorkingHoursId;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime openTime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime closeTime;
}
