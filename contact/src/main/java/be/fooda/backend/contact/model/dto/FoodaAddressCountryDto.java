package be.fooda.backend.contact.model.dto;

import javax.validation.constraints.NotNull;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
public class FoodaAddressCountryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long countryId;
    @NotNull
    private String name;
    private String code;
}
