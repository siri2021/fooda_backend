// FoodaOrderContactRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FoodaOrderContactRes {
    private Long contactId;
    private String firstName;
    private String familyName;
    private String company;
    private String phoneNumber;
    private String email;
    private String call;
}