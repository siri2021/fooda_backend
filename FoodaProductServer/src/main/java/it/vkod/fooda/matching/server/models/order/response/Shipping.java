package it.vkod.fooda.matching.server.models.order.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Shipping {
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String address_1;
    @Getter
    @Setter
    private String address_2;
    @Getter
    @Setter
    private String postcode;
    @Getter
    @Setter
    private String last_name;
    @Getter
    @Setter
    private String company;
    @Getter
    @Setter
    private String state;
    @Getter
    @Setter
    private String first_name;
}
