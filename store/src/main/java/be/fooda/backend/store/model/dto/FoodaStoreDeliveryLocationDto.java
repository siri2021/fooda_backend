package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreDeliveryLocationDto extends FoodaAbstractDto {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeDeliveryLocationId;

    private Long municipalityId;
  
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime deliveryTime;
   
    @Column(columnDefinition = "DECIMAL(8,2)")
    private BigDecimal deliveryCost;
    
    @ManyToOne
    @JoinColumn
    private FoodaStoreDto store;
}
