package be.fooda.backend.store.model.dto;

import lombok.*;

import javax.persistence.*;

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

    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    private FoodaStoreDto store;
}
