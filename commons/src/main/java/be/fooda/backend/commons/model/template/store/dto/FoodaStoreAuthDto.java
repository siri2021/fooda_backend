package be.fooda.backend.commons.model.template.store.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "STORE_AUTH")
public class FoodaStoreAuthDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authId;

//    private FoodaStoreDto store;

    private String key;

    private String secret;

    private LocalDate expiryDate;

}
