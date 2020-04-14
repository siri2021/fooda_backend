package it.vkod.payloads.basketRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BasketOrder{

	@JsonProperty("productOrders")
	private List<ProductOrdersItem> productOrders;

	public void setProductOrders(List<ProductOrdersItem> productOrders){
		this.productOrders = productOrders;
	}

	public List<ProductOrdersItem> getProductOrders(){
		return productOrders;
	}

	@Override
 	public String toString(){
		return 
			"BasketOrder{" + 
			"productOrders = '" + productOrders + '\'' + 
			"}";
		}
}