package be.fooda.backend.contact.model.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "ADDRESS_MUNICIPALITY")
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
