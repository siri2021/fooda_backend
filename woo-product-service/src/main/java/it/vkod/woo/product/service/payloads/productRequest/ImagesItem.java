package it.vkod.woo.product.service.payloads.productRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImagesItem{

	@JsonProperty("src")
	private String src;

	public void setSrc(String src){
		this.src = src;
	}

	public String getSrc(){
		return src;
	}

	@Override
 	public String toString(){
		return 
			"ImagesItem{" + 
			"src = '" + src + '\'' + 
			"}";
		}
}