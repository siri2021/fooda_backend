package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreDto extends FoodaAbstractDto {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;
   
    @NotNull
    private String name;
  
    private String slogan;
  
    private Long bgImageId;
   
    private Long bgVideoId;
  
    private Long addressId;
   
    private Long contactId;
   
    @ManyToOne
    @JoinColumn
    private FoodaStoreTypeDto type;
    
    private Long parentId;
   
    @NotNull
    private String siteUrl;
  
    @NotNull
    private String storeUrl;
  
    private Long logoImageId;
 
    private String about;
  
    @OneToMany(mappedBy = "store")
    private List<FoodaStorePaymentMethodDto> paymentMethods;
  
    @OneToMany(mappedBy = "store")
    private List<FoodaStoreDeliveryCostDto> deliveryCosts;
  
    @OneToMany(mappedBy = "store")
    private List<FoodaStoreDeliveryLocationDto> deliveryLocations;
  
    @OneToMany(mappedBy = "store")
    private List<FoodaStoreWorkingHoursDto> workingHours;
  
    @OneToOne(mappedBy = "store")
    private FoodaStoreAuthDto auth;
   
    public static FoodaStoreDtoBuilder(){
        return new FoodaStoreDtoBuilder(
             @Override
             public FoodaStoreAuthDto auth(final FoodaStoreAuthDto auth){
                 auth.setStore(super.build())
                 super.auth(auth);
             }
        ); 
    }
}
