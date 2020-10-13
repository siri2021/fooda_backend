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
public class FoodaStoreContactDto {

    @Id
    @GeneratedValue
    private Long id;

    private Long contactId;

    private String phone;

    private String email;

    private String firstName;

    private String lastName;

    @OneToOne
    private FoodaStoreDto store;
}
