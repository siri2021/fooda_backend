package it.vkod.woocommerce.server.models.order.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class Billing {
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private String city;
    @Getter
    @Setter
    private String phone;
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
    private String state;
    @Getter
    @Setter
    private String first_name;
    @Getter
    @Setter
    private String email;
}
