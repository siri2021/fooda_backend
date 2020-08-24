// FoodaSubOrderRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaSubOrderRes {
    private FoodaOrderStoreRes store;
    private FoodaOrderStatusRes status;
    private String note;
    private String registry;
    private String required;
    private String delivery;
    private String payment;
    private Double productsTotal;
    private double taxTotal;
    private Double deliveryTotal;
    private double priceTotal;
    private OrderedProduct[] orderedProducts;
    private FoodaOrderPaymentRes[] payments;
    private String registryTime;
    private String requiredTime;
    private String deliveryTime;
    private String paymentTime;
    private Double productsTotalPrice;
}