package be.fooda.backend.store.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class FoodaStoreDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    private String type;

    private Long parentId;

    private String siteUrl;

    private String storeUrl;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreMediaDto logoImage;

    private String about;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<FoodaStorePaymentMethodDto> paymentMethods;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<FoodaStoreDeliveryLocationDto> deliveryLocations;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<FoodaStoreWorkingHoursDto> workingHours;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreAuthDto auth;

}
