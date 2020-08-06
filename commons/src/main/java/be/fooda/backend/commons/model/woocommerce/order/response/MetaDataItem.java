package be.fooda.backend.commons.model.woocommerce.order.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDataItem{

	@JsonProperty("id")
	private int id;

	@JsonProperty("value")
	private String value;

	@JsonProperty("key")
	private String key;
}