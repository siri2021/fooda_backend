// FoodaOrderStatusRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaOrderStatusRes {
    private Long orderStatusId;
    private String title;
    private String parent;
}