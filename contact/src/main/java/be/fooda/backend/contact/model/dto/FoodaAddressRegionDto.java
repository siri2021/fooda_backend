package be.fooda.backend.contact.model.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "ADDRESS_REGION")
public class FoodaAddressRegionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long regionId;
    @NotNull
    private String name;
    @NotNull
    @OneToOne
    private FoodaAddressCountryDto country;
}
