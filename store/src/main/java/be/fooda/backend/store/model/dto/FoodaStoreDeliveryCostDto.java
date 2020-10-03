package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor)
@Builder
@Entity
public class FoodaStoreDeliveryCostDto extends FoodaAbstractDto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeDeliveryCostId;
    
    @Column(columnDefinition = "DECIMAL(8,2)")
    private BigDecimal minPrice;
    
    @Column(columnDefinition = "DECIMAL(8,2)")
    private BigDecimal maxPrice;
    
    @Column(columnDefinition = "DECIMAL(8,2)")
    private BigDecimal amount;
    
    @ManyToOne
    @JoinColumn
    private FoodaStoreDto store;
}
