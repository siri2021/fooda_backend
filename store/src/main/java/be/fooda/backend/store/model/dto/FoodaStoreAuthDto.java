package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FoodaStoreAuthDto extends FoodaAbstractDto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeAuthId;
    
    @NotNull
    private String key;
    
    @NotNull
    private String secret;
    
    @ManyToOne
    @JoinColumn
    private FoodaStoreDto store;
    
    private LocalDate expiryDate;
}
