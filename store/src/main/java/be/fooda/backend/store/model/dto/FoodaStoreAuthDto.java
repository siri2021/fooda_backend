package be.fooda.backend.store.model.dto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreAuthDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String key;

    @NotNull
    private String secret;

    private LocalDate expiryDate;

    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    private FoodaStoreDto store;
}
