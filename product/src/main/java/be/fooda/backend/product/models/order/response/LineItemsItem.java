package be.fooda.backend.product.models.order.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemsItem{

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("tax_class")
	private String taxClass;

	@JsonProperty("taxes")
	private List<TaxesItem> taxes;

	@JsonProperty("total_tax")
	private String totalTax;

	@JsonProperty("total")
	private String total;

	@JsonProperty("variation_id")
	private int variationId;

	@JsonProperty("subtotal")
	private String subtotal;

	@JsonProperty("price")
	private int price;

	@JsonProperty("product_id")
	private int productId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("meta_data")
	private List<Object> metaData;

	@JsonProperty("id")
	private int id;

	@JsonProperty("subtotal_tax")
	private String subtotalTax;

	@JsonProperty("sku")
	private String sku;
}