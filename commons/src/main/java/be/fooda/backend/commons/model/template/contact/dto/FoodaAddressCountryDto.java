package be.fooda.backend.commons.model.template.contact.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "ADDRESS_COUNTRY")
public class FoodaAddressCountryDto {
    private Long countryId;
    @NotNull
    private String name;
    private String code;
}
