package it.vkod.woo.matching.service.payloads.productResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SelfItem{

	@JsonProperty("href")
	private String href;

	public void setHref(String href){
		this.href = href;
	}

	public String getHref(){
		return href;
	}

	@Override
 	public String toString(){
		return 
			"SelfItem{" + 
			"href = '" + href + '\'' + 
			"}";
		}
}