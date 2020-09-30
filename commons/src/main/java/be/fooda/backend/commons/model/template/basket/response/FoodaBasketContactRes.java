package be.fooda.backend.commons.model.template.basket.response;

import be.fooda.backend.commons.service.validator.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class FoodaBasketContactRes {
    private Long contactId;
    private String firstName;
    private String familyName;
    private String companyName;
    @PhoneNumber
    private String phoneNumber;
    @Email
    private String email;
    private Boolean canCall;
}
