package it.vkod.woo.product.client.pojo.product.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dimensions{
	@Getter
	@Setter
	private String length;
	@Getter
	@Setter
	private String width;
	@Getter
	@Setter
	private String height;

}