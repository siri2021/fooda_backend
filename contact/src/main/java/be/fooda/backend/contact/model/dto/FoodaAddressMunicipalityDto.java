package be.fooda.backend.contact.model.dto;

import javax.validation.constraints.NotNull;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class FoodaAddressMunicipalityDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long municipalityId;
    @NotNull
    private String name;
    @NotNull
    private String postcode;
    @NotNull
    @OneToOne
    private FoodaAddressCityDto city;
}
