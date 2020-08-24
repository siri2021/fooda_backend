package be.fooda.backend.commons.model.template.contact.response;

import be.fooda.backend.commons.service.validator.PhoneNumber;
import lombok.*;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
public class FoodaContactRes {
    private Integer contactId;
    private Integer userId;
    private String firstName;
    private String familyName;
    private String companyName;
    @PhoneNumber
    private String phoneNumber;
    @Email
    private String email;
    private Boolean canCall;
}