package it.vkod.woo.core.payloads.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ShippingLinesItem{

	@JsonProperty("total")
	private String total;

	@JsonProperty("method_id")
	private String methodId;

	@JsonProperty("meta_data")
	private List<Object> metaData;

	@JsonProperty("taxes")
	private List<Object> taxes;

	@JsonProperty("id")
	private int id;

	@JsonProperty("total_tax")
	private String totalTax;

	@JsonProperty("method_title")
	private String methodTitle;

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setMethodId(String methodId){
		this.methodId = methodId;
	}

	public String getMethodId(){
		return methodId;
	}

	public void setMetaData(List<Object> metaData){
		this.metaData = metaData;
	}

	public List<Object> getMetaData(){
		return metaData;
	}

	public void setTaxes(List<Object> taxes){
		this.taxes = taxes;
	}

	public List<Object> getTaxes(){
		return taxes;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setTotalTax(String totalTax){
		this.totalTax = totalTax;
	}

	public String getTotalTax(){
		return totalTax;
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
			",meta_data = '" + metaData + '\'' + 
			",taxes = '" + taxes + '\'' + 
			",id = '" + id + '\'' + 
			",total_tax = '" + totalTax + '\'' + 
			",method_title = '" + methodTitle + '\'' + 
			"}";
		}
}