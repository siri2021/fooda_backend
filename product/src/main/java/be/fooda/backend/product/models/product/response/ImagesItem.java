package be.fooda.backend.product.models.product.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesItem{

	@JsonProperty("id")
	private int id;

	@JsonProperty("src")
	private String src;

	@JsonProperty("alt")
	private String alt;
}