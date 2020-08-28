package be.fooda.backend.order.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ORDER")
public class FoodaOrderDto extends FoodaAbstractDto{
    @EmbeddedId
    private FoodaOrderKeyDto orderKey;
    @OneToOne
    private FoodaOrderStatusDto orderStatus;
    private String note;
    private LocalDateTime requiredTime;
    private LocalDateTime deliveryTime;
    private LocalDateTime paymentTime;
    private BigDecimal productsTotal;
    private BigDecimal taxTotal;
    private BigDecimal deliveryTotal;
    private BigDecimal priceTotal;
    @OneToMany
    private List<FoodaOrderProductDto> products;
    @OneToMany
    private List<FoodaOrderPaymentDto> payments;
}