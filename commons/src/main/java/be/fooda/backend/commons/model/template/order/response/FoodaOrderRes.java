// FoodaSubOrderRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderRes {
    private Long orderId;
    private Long externalOrderId;
    private Long userId;
    private FoodaOrderBillingRes billing;
    private FoodaOrderDeliveryRes delivery;
    private FoodaOrderStoreRes store;
    private FoodaOrderStatusRes status;
    private String note;
    private BigDecimal productsTotal;
    private BigDecimal taxTotal;
    private BigDecimal deliveryTotal;
    private BigDecimal priceTotal;
    private List<FoodaOrderProductRes> orderedProducts;
    private List<FoodaOrderPaymentRes> payments;
    private LocalDateTime registryTime;
    private LocalDateTime requiredTime;
    private LocalDateTime deliveryTime;
    private LocalDateTime paymentTime;
}