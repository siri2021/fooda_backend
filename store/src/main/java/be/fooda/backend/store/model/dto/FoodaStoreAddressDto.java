package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreAddressDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue
    private Long storeAddressId;

    private Long addressId;

    private String postcode;

    private String municipality;

    private String city;
}
