package be.fooda.backend.commons.model.template.contact.dto;

import be.fooda.backend.commons.service.validator.PhoneNumber;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Data
@Builder
@Entity
@Table(name = "CONTACT")
public class FoodaContactDto {
    @Id
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