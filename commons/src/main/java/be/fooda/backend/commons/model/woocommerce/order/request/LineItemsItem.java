package be.fooda.backend.commons.model.woocommerce.order.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LineItemsItem{

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("variation_id")
	private int variationId;

	@JsonProperty("product_id")
	private int productId;
}