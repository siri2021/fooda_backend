package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class FoodaStorePaymentMethodDto extends FoodaAbstractDto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storePaymentMethodId;
    
    private Long paymentMethodId;
    
    private BigDecimal minOrderAmount;
    
    private LocalDate expiryDate;
    
    @ManyToOne
    @JoinColumn
    private FoodaStoreDto store;
}
