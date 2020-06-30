package it.vkod.fooda.product.server.models.order.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Links{

	@JsonProperty("self")
	private List<SelfItem> self;

	@JsonProperty("collection")
	private List<CollectionItem> collection;
}