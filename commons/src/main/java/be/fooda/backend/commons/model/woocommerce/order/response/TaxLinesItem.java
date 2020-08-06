package be.fooda.backend.commons.model.woocommerce.order.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxLinesItem{

	@JsonProperty("tax_total")
	private String taxTotal;

	@JsonProperty("rate_id")
	private int rateId;

	@JsonProperty("meta_data")
	private List<Object> metaData;

	@JsonProperty("id")
	private int id;

	@JsonProperty("label")
	private String label;

	@JsonProperty("rate_code")
	private String rateCode;

	@JsonProperty("compound")
	private boolean compound;

	@JsonProperty("shipping_tax_total")
	private String shippingTaxTotal;
}