package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreWorkingHoursDto extends FoodaAbstractDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeWorkingHoursId;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate workingDate;
   
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime openTime;
    
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime closeTime;
    
    @ManyToOne
    @JoinColumn
    private FoodaStoreDto store;
}
