// FoodaOrderStatusRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@Data
@Builder
public class FoodaOrderStatusReq {
    private String title;
    private String parent;
}