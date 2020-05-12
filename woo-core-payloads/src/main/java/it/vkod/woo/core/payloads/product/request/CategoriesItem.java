package it.vkod.woo.core.payloads.product.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriesItem{

	@JsonProperty("id")
	private int id;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"CategoriesItem{" + 
			"id = '" + id + '\'' + 
			"}";
		}
}