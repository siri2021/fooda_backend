package be.fooda.backend.commons.model.template.contact.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "ADDRESS")
public class FoodaAddressDto { // CRUD operations
    @Id
    private Integer addressId;
    private Integer userId;
    private String doorNo;
    private String number;
    private String street;
    private String municipality;
    private String postcode;
    private String city;
    private String region;
    private String country;
}