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

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreMediaDto bgImage;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreMediaDto bgVideo;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreAddressDto address;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreContactDto contact;

    @ManyToOne
    @JoinColumn
    private FoodaStoreTypeDto type;

    private Long parentId;

    @NotNull
    private String siteUrl;

    @NotNull
    private String storeUrl;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreMediaDto logoImage;

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


}
