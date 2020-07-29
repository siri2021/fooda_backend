package be.fooda.backend.product.models.order.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
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

	@JsonProperty("state")
	private String state;

	@JsonProperty("first_name")
	private String firstName;
}