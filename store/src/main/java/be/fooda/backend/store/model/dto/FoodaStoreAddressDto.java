package be.fooda.backend.store.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    @OneToOne
    private FoodaStoreDto store;
}
