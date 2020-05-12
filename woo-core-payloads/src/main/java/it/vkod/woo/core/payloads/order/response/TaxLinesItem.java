package it.vkod.woo.core.payloads.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TaxLinesItem{

	@JsonProperty("tax_total")
	private String taxTotal;

	@JsonProperty("rate_id")
	private int rateId;

	@JsonProperty("meta_data")
	private List<Object> metaData;

	@JsonProperty("id")
	private int id;

	@JsonProperty("label")
	private String label;

	@JsonProperty("rate_code")
	private String rateCode;

	@JsonProperty("compound")
	private boolean compound;

	@JsonProperty("shipping_tax_total")
	private String shippingTaxTotal;

	public void setTaxTotal(String taxTotal){
		this.taxTotal = taxTotal;
	}

	public String getTaxTotal(){
		return taxTotal;
	}

	public void setRateId(int rateId){
		this.rateId = rateId;
	}

	public int getRateId(){
		return rateId;
	}

	public void setMetaData(List<Object> metaData){
		this.metaData = metaData;
	}

	public List<Object> getMetaData(){
		return metaData;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setRateCode(String rateCode){
		this.rateCode = rateCode;
	}

	public String getRateCode(){
		return rateCode;
	}

	public void setCompound(boolean compound){
		this.compound = compound;
	}

	public boolean isCompound(){
		return compound;
	}

	public void setShippingTaxTotal(String shippingTaxTotal){
		this.shippingTaxTotal = shippingTaxTotal;
	}

	public String getShippingTaxTotal(){
		return shippingTaxTotal;
	}

	@Override
 	public String toString(){
		return 
			"TaxLinesItem{" + 
			"tax_total = '" + taxTotal + '\'' + 
			",rate_id = '" + rateId + '\'' + 
			",meta_data = '" + metaData + '\'' + 
			",id = '" + id + '\'' + 
			",label = '" + label + '\'' + 
			",rate_code = '" + rateCode + '\'' + 
			",compound = '" + compound + '\'' + 
			",shipping_tax_total = '" + shippingTaxTotal + '\'' + 
			"}";
		}
}