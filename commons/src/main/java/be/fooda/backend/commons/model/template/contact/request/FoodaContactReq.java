package be.fooda.backend.commons.model.template.contact.request;

import be.fooda.backend.commons.service.validator.PhoneNumber;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@Builder
public class FoodaContactReq {
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