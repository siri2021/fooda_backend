package be.fooda.backend.store.model.dto;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStorePaymentMethodDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long paymentMethodId;

    private BigDecimal minOrderAmount;

    private LocalDate expiryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private FoodaStoreDto store;
}
