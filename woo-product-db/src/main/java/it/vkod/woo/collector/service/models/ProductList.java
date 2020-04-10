package it.vkod.woo.collector.service.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ProductList {

  @JsonProperty
  List<Product> productList = new ArrayList<>();

  @Override
  public String toString() {
    return "ProductList: {" +
        "productList=" + productList +
        '}';
  }

  public ProductList() {
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }
}
