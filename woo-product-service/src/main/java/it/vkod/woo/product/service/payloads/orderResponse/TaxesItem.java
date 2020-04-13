package it.vkod.woo.product.service.payloads.orderResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxesItem{

	@JsonProperty("total")
	private String total;

	@JsonProperty("subtotal")
	private String subtotal;

	@JsonProperty("id")
	private int id;

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setSubtotal(String subtotal){
		this.subtotal = subtotal;
	}

	public String getSubtotal(){
		return subtotal;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"TaxesItem{" + 
			"total = '" + total + '\'' + 
			",subtotal = '" + subtotal + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}