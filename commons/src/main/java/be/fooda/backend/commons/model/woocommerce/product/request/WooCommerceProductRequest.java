package be.fooda.backend.commons.model.woocommerce.product.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WooCommerceProductRequest{

	@JsonProperty("regular_price")
	private String regularPrice;

	@JsonProperty("short_description")
	private String shortDescription;

	@JsonProperty("images")
	private List<ImagesItem> images;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("categories")
	private List<CategoriesItem> categories;

	@JsonProperty("type")
	private String type;
}