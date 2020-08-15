package be.fooda.backend.commons.model.template.contact.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "CONTACT")
public class FoodaContactRequest {

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
    private String phoneNumber;

    @Column(name = "email")
    @Email
    private String email;
    
    @Column(name = "can_call")
    private Boolean canCall;
}