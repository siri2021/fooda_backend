package be.fooda.backend.commons.model.template.contact.dto;

import javax.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Table(name = "ADDRESS")
public class FoodaAddressDto {
    
    @Id
    @Column(name = "address_id")
    private Integer addressId;
    
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "door_no")
    private String doorNo;
    
    @Column(name = "number")
    private String number;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "municipality")
    private String municipality;
    
    @Column(name = "postcode")
    private String postcode;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "region")
    private String region;
    
    @Column(name = "country")
    private String country;
}