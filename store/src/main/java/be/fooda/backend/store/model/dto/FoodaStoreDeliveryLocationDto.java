package be.fooda.backend.store.model.dto;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreDeliveryLocationDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long municipalityId; // zele

    private Double deliveryTime;

    @Column(columnDefinition = "DECIMAL(8,2)")
    private BigDecimal minOrderPrice;

    @Column(columnDefinition = "DECIMAL(8,2)")
    private BigDecimal maxOrderPrice;

    @Column(columnDefinition = "DECIMAL(8,2)")
    private BigDecimal deliveryCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private FoodaStoreDto store;
}
