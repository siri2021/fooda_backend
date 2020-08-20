package be.fooda.backend.commons.model.template.store.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "STORE_TYPE")
public class FoodaStoreTypeDto extends FoodaAbstractDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
}
