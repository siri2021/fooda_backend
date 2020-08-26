package be.fooda.backend.commons.model.template.contact.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "ADDRESS")
public class FoodaAddressDto { // CRUD operations
    @Id
    private Long addressId;
    @NotNull
    private Long userId;
    private String doorNo;
    private String number;
    @NotNull
    private String street;
    @NotNull
    private FoodaAddressMunicipalityDto municipality;
}