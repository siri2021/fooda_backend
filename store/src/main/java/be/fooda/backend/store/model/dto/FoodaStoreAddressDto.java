package be.fooda.backend.store.model.dto;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreAddressDto {

    @Id
    @GeneratedValue
    private Long id;

    private Long addressId;

    private String postcode;

    private String municipality;

    private String city;

    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    private FoodaStoreDto store;
}
