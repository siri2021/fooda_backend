package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreTypeDto extends FoodaAbstractDto {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    @NotNull
    private String title;
    
    @OneToMany
    private List<FoodaStoreDto> stores;
}
