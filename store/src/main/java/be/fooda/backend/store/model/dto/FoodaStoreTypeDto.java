package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    
    @OneToMany(mappedBy = "type")
    private List<FoodaStoreDto> stores;
}
