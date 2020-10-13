package be.fooda.backend.store.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FoodaStoreDeliveryCostDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
