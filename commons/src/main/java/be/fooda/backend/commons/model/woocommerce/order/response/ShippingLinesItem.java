package be.fooda.backend.commons.model.woocommerce.order.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingLinesItem{

	@JsonProperty("total")
	private String total;

	@JsonProperty("method_id")
	private String methodId;

	@JsonProperty("meta_data")
	private List<Object> metaData;

	@JsonProperty("taxes")
	private List<Object> taxes;

	@JsonProperty("id")
	private int id;

	@JsonProperty("total_tax")
	private String totalTax;

	@JsonProperty("method_title")
	private String methodTitle;
}