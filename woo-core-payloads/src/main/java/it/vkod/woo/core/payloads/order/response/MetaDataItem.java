package it.vkod.woo.core.payloads.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaDataItem{

	@JsonProperty("id")
	private int id;

	@JsonProperty("value")
	private String value;

	@JsonProperty("key")
	private String key;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setKey(String key){
		this.key = key;
	}

	public String getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"MetaDataItem{" + 
			"id = '" + id + '\'' + 
			",value = '" + value + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}