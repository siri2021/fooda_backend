package be.fooda.backend.commons.model.template.order.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "ORDER")
public class FoodaOrderDto extends FoodaAbstractDto{
    @EmbeddedId
    private FoodaOrderKeyDto orderKey;
    private FoodaOrderStatusDto orderStatus;
    private String note;
    private LocalDateTime requiredTime;
    private LocalDateTime deliveryTime;
    private LocalDateTime paymentTime;
    private BigDecimal productsTotal;
    private BigDecimal taxTotal;
    private BigDecimal deliveryTotal;
    private BigDecimal priceTotal;
    private List<FoodaOrderProductDto> products;
    private List<FoodaOrderPaymentDto> payments;
}