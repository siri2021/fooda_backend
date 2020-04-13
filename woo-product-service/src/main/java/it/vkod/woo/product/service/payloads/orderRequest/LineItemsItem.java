package it.vkod.woo.product.service.payloads.orderRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LineItemsItem{

	@JsonProperty("quantity")
	private int quantity;

	@JsonProperty("variation_id")
	private int variationId;

	@JsonProperty("product_id")
	private int productId;

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setVariationId(int variationId){
		this.variationId = variationId;
	}

	public int getVariationId(){
		return variationId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductId(){
		return productId;
	}

	@Override
 	public String toString(){
		return 
			"LineItemsItem{" + 
			"quantity = '" + quantity + '\'' + 
			",variation_id = '" + variationId + '\'' + 
			",product_id = '" + productId + '\'' + 
			"}";
		}
}