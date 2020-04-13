package it.vkod.woo.matching.service.payloads.productResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Links{

	@JsonProperty("self")
	private List<SelfItem> self;

	@JsonProperty("collection")
	private List<CollectionItem> collection;

	public void setSelf(List<SelfItem> self){
		this.self = self;
	}

	public List<SelfItem> getSelf(){
		return self;
	}

	public void setCollection(List<CollectionItem> collection){
		this.collection = collection;
	}

	public List<CollectionItem> getCollection(){
		return collection;
	}

	@Override
 	public String toString(){
		return 
			"Links{" + 
			"self = '" + self + '\'' + 
			",collection = '" + collection + '\'' + 
			"}";
		}
}