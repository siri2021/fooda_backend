package be.fooda.backend.contact.model.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "ADDRESS_COUNTRY")
public class FoodaAddressCountryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long countryId;
    @NotNull
    private String name;
    private String code;
}
