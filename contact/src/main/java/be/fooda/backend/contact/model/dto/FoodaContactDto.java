package be.fooda.backend.contact.model.dto;

import be.fooda.backend.commons.service.validator.PhoneNumber;

import lombok.*;
import javax.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class FoodaContactDto {
    @Id
    private Integer contactId;
    @NotNull
    private Integer userId;
    @NotNull
    private String firstName;
    @NotNull
    private String familyName;
    private String companyName;
    @PhoneNumber
    private String phoneNumber;
    @Email
    private String email;
    private Boolean canCall;
}