package it.vkod.woo.product.client.payloads.basketRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductOrdersItem{

	@JsonProperty("product")
	private BasketProduct product;

	@JsonProperty("quantity")
	private int quantity;

	public void setProduct(BasketProduct product){
		this.product = product;
	}

	public BasketProduct getProduct(){
		return product;
	}

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	@Override
 	public String toString(){
		return 
			"ProductOrdersItem{" + 
			"product = '" + product + '\'' + 
			",quantity = '" + quantity + '\'' + 
			"}";
		}
}