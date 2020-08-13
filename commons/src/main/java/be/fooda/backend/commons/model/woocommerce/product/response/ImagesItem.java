package be.fooda.backend.commons.model.woocommerce.product.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ImagesItem{

	@JsonProperty("date_modified_gmt")
	private String dateModifiedGmt;

	@JsonProperty("date_modified")
	private String dateModified;

	@JsonProperty("src")
	private String src;

	@JsonProperty("date_created")
	private String dateCreated;

	@JsonProperty("name")
	private String name;

	@JsonProperty("alt")
	private String alt;

	@JsonProperty("date_created_gmt")
	private String dateCreatedGmt;

	@JsonProperty("id")
	private Integer id;
}