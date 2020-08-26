package be.fooda.backend.commons.model.template.store.dto;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "STORE")
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
    private FoodaStoreTypeDto type;
    private FoodaStoreDto parent;
    @NotNull
    private String siteUrl;
    @NotNull
    private String storeUrl;
    private Long logoImageId;
    private String about;
    private List<FoodaStorePaymentMethodDto> paymentMethods;
    private List<FoodaStoreDeliveryCostDto> deliveryCosts;
    private List<FoodaStoreDeliveryLocationDto> deliveryLocations;
    private List<FoodaStoreWorkingHoursDto> workingHours;
    private FoodaStoreAuthDto auth;
}
