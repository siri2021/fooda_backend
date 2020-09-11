package be.fooda.backend.contact.model.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ADDRESS_CITY")
public class FoodaAddressCityDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cityId;
    @NotNull
    private String name;
    @NotNull
    @OneToOne
    private FoodaAddressRegionDto region;
}
