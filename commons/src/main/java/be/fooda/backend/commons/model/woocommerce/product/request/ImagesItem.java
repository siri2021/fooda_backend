package be.fooda.backend.commons.model.woocommerce.product.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ImagesItem implements Serializable {
	@JsonProperty("src")
	private String src;
}