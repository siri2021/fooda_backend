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

    @NotNull
    private String name;

    private String slogan;

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreMediaDto bgImage;

    public void setBgImage(FoodaStoreMediaDto bgImage) {
        bgImage.setStore(this);
        this.bgImage = bgImage;
    }

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreMediaDto bgVideo;

    public void setBgVideo(FoodaStoreMediaDto bgVideo) {
        bgVideo.setStore(this);
        this.bgVideo = bgVideo;
    }

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreAddressDto address;

    public void setAddress(FoodaStoreAddressDto address) {
        address.setStore(this);
        this.address = address;
    }

    @OneToOne(mappedBy = "store", cascade = CascadeType.ALL)
    private FoodaStoreContactDto contact;

    public void setContact(FoodaStoreContactDto contact) {
        contact.setStore(this);
        this.contact = contact;
    }

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

    public void setLogoImage(FoodaStoreMediaDto logoImage) {
        logoImage.setStore(this);
        this.logoImage = logoImage;
    }

    private String about;

    @OneToMany(mappedBy = "store")
    private List<FoodaStorePaymentMethodDto> paymentMethods;

    public void addPaymentMethod(FoodaStorePaymentMethodDto paymentMethod) {
        paymentMethod.setStore(this);
        this.paymentMethods.add(paymentMethod);
    }

    public void removePaymentMethod(FoodaStorePaymentMethodDto paymentMethod) {
        paymentMethod.setStore(null);
        this.paymentMethods.remove(paymentMethod);
    }

    public void setPaymentMethods(List<FoodaStorePaymentMethodDto> paymentMethods) {
        paymentMethods.forEach(payMet -> payMet.setStore(this));
        this.paymentMethods = paymentMethods;
    }

    @OneToMany(mappedBy = "store")
    private List<FoodaStoreDeliveryLocationDto> deliveryLocations;

    public void addDeliveryLocation(FoodaStoreDeliveryLocationDto deliveryLocation) {
        deliveryLocation.setStore(this);
        this.deliveryLocations.add(deliveryLocation);
    }

    public void removeDeliveryLocation(FoodaStoreDeliveryLocationDto deliveryLocation) {
        deliveryLocation.setStore(null);
        this.deliveryLocations.remove(deliveryLocation);
    }

    public void setDeliveryLocations(List<FoodaStoreDeliveryLocationDto> deliveryLocations) {
        deliveryLocations.forEach(delLoc -> delLoc.setStore(this));
        this.deliveryLocations = deliveryLocations;
    }

    @OneToMany(mappedBy = "store")
    private List<FoodaStoreWorkingHoursDto> workingHours;

    public void addWorkingHours(FoodaStoreWorkingHoursDto workingHours) {
        workingHours.setStore(this);
        this.workingHours.add(workingHours);
    }

    public void removeWorkingHours(FoodaStoreWorkingHoursDto workingHours) {
        workingHours.setStore(null);
        this.workingHours.remove(workingHours);
    }

    public void setWorkingHours(List<FoodaStoreWorkingHoursDto> workingHours) {
        workingHours.forEach(workHour -> workHour.setStore(this));
        this.workingHours = workingHours;
    }

    @OneToOne(mappedBy = "store")
    private FoodaStoreAuthDto auth;

    public void setAbout(String about) {
        auth.setStore(this);
        this.about = about;
    }
}
