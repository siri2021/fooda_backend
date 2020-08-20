package be.fooda.backend.commons.model.template.contact.dto;

import javax.persistence.*;
import javax.validation.constraints.Email;

import be.fooda.backend.commons.service.validator.PhoneNumber;
import lombok.*;

@Data
@Builder
@Table(name = "CONTACT")
public class FoodaContactDto {

    @Id
    @Column(name = "contact_id" )
    private Integer contactId;
    
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "family_name")
    private String familyName;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_number")
    @PhoneNumber
    private String phoneNumber;

    @Column(name = "email")
    @Email
    private String email;
    
    @Column(name = "can_call")
    private Boolean canCall;
}