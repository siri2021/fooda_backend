package be.fooda.backend.store.model.dto;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreMediaDto {

    @Id
    @GeneratedValue
    private Long id;

    private Long mediaId;

    private String url;

    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    private FoodaStoreDto store;
}
