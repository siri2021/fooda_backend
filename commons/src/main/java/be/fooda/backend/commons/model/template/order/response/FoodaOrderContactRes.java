// FoodaOrderContactRes.java

package be.fooda.backend.commons.model.template.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class FoodaOrderContactRes {
    private Long contactId;
    private String firstName;
    private String familyName;
    private String company;
    private String phoneNumber;
    private String email;
    private String call;
}