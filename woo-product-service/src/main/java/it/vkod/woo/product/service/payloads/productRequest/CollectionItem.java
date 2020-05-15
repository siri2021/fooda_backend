package it.vkod.woo.product.service.payloads.productRequest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class CollectionItem{

	@Getter
	@Setter
	private String href;
}