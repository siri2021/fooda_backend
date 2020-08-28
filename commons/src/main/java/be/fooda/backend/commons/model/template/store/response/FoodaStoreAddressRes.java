package be.fooda.backend.commons.model.template.store.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.*;

@NoArgsConstructor
@Data
@Builder
public class FoodaStoreAddressRes {


    private String number;


    private String country;


    private String city;


    private String street;


    private String doorNo;


    private String municipality;


    private String region;
}