package it.vkod.woo.core.payloads.order.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LineItemsItem{

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("tax_class")
	private String taxClass;

	@JsonProperty("taxes")
	private List<TaxesItem> taxes;

	@JsonProperty("total_tax")
	private String totalTax;

	@JsonProperty("total")
	private String total;

	@JsonProperty("variation_id")
	private int variationId;

	@JsonProperty("subtotal")
	private String subtotal;

	@JsonProperty("price")
	private int price;

	@JsonProperty("product_id")
	private int productId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("meta_data")
	private List<Object> metaData;

	@JsonProperty("id")
	private int id;

	@JsonProperty("subtotal_tax")
	private String subtotalTax;

	@JsonProperty("sku")
	private String sku;

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setTaxClass(String taxClass){
		this.taxClass = taxClass;
	}

	public String getTaxClass(){
		return taxClass;
	}

	public void setTaxes(List<TaxesItem> taxes){
		this.taxes = taxes;
	}

	public List<TaxesItem> getTaxes(){
		return taxes;
	}

	public void setTotalTax(String totalTax){
		this.totalTax = totalTax;
	}

	public String getTotalTax(){
		return totalTax;
	}

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setVariationId(int variationId){
		this.variationId = variationId;
	}

	public int getVariationId(){
		return variationId;
	}

	public void setSubtotal(String subtotal){
		this.subtotal = subtotal;
	}

	public String getSubtotal(){
		return subtotal;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductId(){
		return productId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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

	public void setSubtotalTax(String subtotalTax){
		this.subtotalTax = subtotalTax;
	}

	public String getSubtotalTax(){
		return subtotalTax;
	}

	public void setSku(String sku){
		this.sku = sku;
	}

	public String getSku(){
		return sku;
	}

	@Override
 	public String toString(){
		return 
			"LineItemsItem{" + 
			"quantity = '" + quantity + '\'' + 
			",tax_class = '" + taxClass + '\'' + 
			",taxes = '" + taxes + '\'' + 
			",total_tax = '" + totalTax + '\'' + 
			",total = '" + total + '\'' + 
			",variation_id = '" + variationId + '\'' + 
			",subtotal = '" + subtotal + '\'' + 
			",price = '" + price + '\'' + 
			",product_id = '" + productId + '\'' + 
			",name = '" + name + '\'' + 
			",meta_data = '" + metaData + '\'' + 
			",id = '" + id + '\'' + 
			",subtotal_tax = '" + subtotalTax + '\'' + 
			",sku = '" + sku + '\'' + 
			"}";
		}
}