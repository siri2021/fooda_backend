package it.vkod.woo.product.service.payloads.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@JsonAutoDetect
@NoArgsConstructor
public class SelfItem{
	@Getter
	@Setter
	private String href;
}
