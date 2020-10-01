package be.fooda.backend.contact.model.dto;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@Entity
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
