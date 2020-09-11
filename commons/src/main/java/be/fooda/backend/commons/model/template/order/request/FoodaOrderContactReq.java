// FoodaOrderContactRes.java

package be.fooda.backend.commons.model.template.order.request;

import lombok.*;

@NoArgsConstructor
@Data
public class FoodaOrderContactReq {
    private String firstName;
    private String familyName;
    private String company;
    private String phoneNumber;
    private String email;
    private String call;
}