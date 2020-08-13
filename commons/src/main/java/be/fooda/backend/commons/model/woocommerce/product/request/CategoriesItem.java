package be.fooda.backend.commons.model.woocommerce.product.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriesItem{

	@JsonProperty("id")
	private int id;
}