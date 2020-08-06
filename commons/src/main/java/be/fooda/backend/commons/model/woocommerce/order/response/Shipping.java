package be.fooda.backend.commons.model.woocommerce.order.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shipping{

	@JsonProperty("country")
	private String country;

	@JsonProperty("city")
	private String city;

	@JsonProperty("address_1")
	private String address1;

	@JsonProperty("address_2")
	private String address2;

	@JsonProperty("postcode")
	private String postcode;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("company")
	private String company;

	@JsonProperty("state")
	private String state;

	@JsonProperty("first_name")
	private String firstName;
}