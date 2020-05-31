package it.vkod.woo.product.client.pojo.order.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderBilling {
    @Getter
    @Setter
    @JsonProperty("country")
    private String country;
    @Getter
    @Setter
    @JsonProperty("city")
    private String city;
    @Getter
    @Setter
    @JsonProperty("phone")
    private String phone;
    @Getter
    @Setter
    @JsonProperty("address_1")
    private String address1;
    @Getter
    @Setter
    @JsonProperty("address_2")
    private String address2;
    @Getter
    @Setter
    @JsonProperty("postcode")
    private String postcode;
    @Getter
    @Setter
    @JsonProperty("last_name")
    private String lastName;
    @Getter
    @Setter
    @JsonProperty("state")
    private String state;
    @Getter
    @Setter
    @JsonProperty("first_name")
    private String firstName;
    @Getter
    @Setter
    @JsonProperty("email")
    private String email;
}
