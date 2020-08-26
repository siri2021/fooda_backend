package be.fooda.backend.commons.model.template.contact.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "ADDRESS_MUNICIPALITY")
public class FoodaAddressMunicipalityDto {
    private Long municipalityId;
    @NotNull
    private String name;
    @NotNull
    private String postcode;
    private FoodaAddressCityDto city;
}
