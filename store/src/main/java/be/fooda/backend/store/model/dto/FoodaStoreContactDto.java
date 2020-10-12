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
public class FoodaStoreContactDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue
    private Long storeContactId;

    private Long contactId;

    private String phone;

    private String email;

    private String firstName;

    private String lastName;
}
