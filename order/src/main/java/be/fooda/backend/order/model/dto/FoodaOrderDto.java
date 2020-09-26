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
public class FoodaOrderDto extends FoodaAbstractDto {
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

    public void addProduct(final FoodaOrderProductDto product) {
        this.products.add(product);
    }

    public void removeProduct(final FoodaOrderProductDto product) {
        this.products.remove(product);
    }

    public void addPayment(final FoodaOrderPaymentDto payment) {
        this.payments.add(payment);
    }

    public void removePayment(final FoodaOrderPaymentDto payment) {
        this.payments.remove(payment);
    }
}