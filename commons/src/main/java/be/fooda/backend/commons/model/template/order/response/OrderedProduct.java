// OrderedProduct.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.*;

@NoArgsConstructor
@Data
public class OrderedProduct {
    private long productID;
    private String name;
    private long quantity;
    private double price;
    private FoodaOrderVariantRes variant;
    private String type;
}