package it.vkod.woo.product.service.payloads.productRequest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links{

	@Getter @Setter
	private List<SelfItem> self;

	@Getter @Setter
	private List<CollectionItem> collection;
}