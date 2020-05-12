package it.vkod.woo.core.payloads.order.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingLinesItem{

	@JsonProperty("total")
	private int total;

	@JsonProperty("method_id")
	private String methodId;

	@JsonProperty("method_title")
	private String methodTitle;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setMethodId(String methodId){
		this.methodId = methodId;
	}

	public String getMethodId(){
		return methodId;
	}

	public void setMethodTitle(String methodTitle){
		this.methodTitle = methodTitle;
	}

	public String getMethodTitle(){
		return methodTitle;
	}

	@Override
 	public String toString(){
		return 
			"ShippingLinesItem{" + 
			"total = '" + total + '\'' + 
			",method_id = '" + methodId + '\'' + 
			",method_title = '" + methodTitle + '\'' + 
			"}";
		}
}