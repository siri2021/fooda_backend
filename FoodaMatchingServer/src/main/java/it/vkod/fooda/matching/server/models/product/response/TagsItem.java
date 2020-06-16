package it.vkod.fooda.matching.server.models.product.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagsItem{

	@Getter @Setter
	private String name;

	@Getter @Setter
	private int id;

	@Getter @Setter
	private String slug;

}