package be.fooda.backend.contact.model.dto;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
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
