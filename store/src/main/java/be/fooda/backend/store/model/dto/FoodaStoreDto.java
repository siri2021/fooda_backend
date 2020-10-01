package be.fooda.backend.store.model.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
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
    @OneToOne
    private FoodaStoreTypeDto type;
    @OneToOne
    private FoodaStoreDto parent;
    @NotNull
    private String siteUrl;
    @NotNull
    private String storeUrl;
    private Long logoImageId;
    private String about;
    @OneToMany
    private List<FoodaStorePaymentMethodDto> paymentMethods;
    @OneToMany
    private List<FoodaStoreDeliveryCostDto> deliveryCosts;
    @OneToMany
    private List<FoodaStoreDeliveryLocationDto> deliveryLocations;
    @OneToMany
    private List<FoodaStoreWorkingHoursDto> workingHours;
    @OneToOne
    private FoodaStoreAuthDto auth;
}
