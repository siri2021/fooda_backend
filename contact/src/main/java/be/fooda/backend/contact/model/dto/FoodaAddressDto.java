package be.fooda.backend.contact.model.dto;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public class FoodaAddressDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;
    @NotNull
    private Long userId;
    private String doorNo;
    private String number;
    @NotNull
    private String street;
    @NotNull
    @OneToOne
    private FoodaAddressMunicipalityDto municipality;
}