package it.vkod.woo.matching.service.payloads.productResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dimensions{

	@JsonProperty("length")
	private String length;

	@JsonProperty("width")
	private String width;

	@JsonProperty("height")
	private String height;

	public void setLength(String length){
		this.length = length;
	}

	public String getLength(){
		return length;
	}

	public void setWidth(String width){
		this.width = width;
	}

	public String getWidth(){
		return width;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"Dimensions{" + 
			"length = '" + length + '\'' + 
			",width = '" + width + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}