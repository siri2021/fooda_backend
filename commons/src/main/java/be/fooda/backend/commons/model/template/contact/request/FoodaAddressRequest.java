package be.fooda.backend.commons.model.template.contact.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "ADDRESS")
public class FoodaAddressRequest {
    
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