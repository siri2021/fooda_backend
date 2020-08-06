package be.fooda.backend.commons.model.woocommerce.order.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShippingLinesItem{

	@JsonProperty("total")
	private int total;

	@JsonProperty("method_id")
	private String methodId;

	@JsonProperty("method_title")
	private String methodTitle;
}