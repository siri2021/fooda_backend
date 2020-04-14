package it.vkod.payloads.basketRequest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class OrderProduct implements Serializable {

    @JsonIgnore
    private OrderProductPK pk;

    @JsonProperty
    private Integer quantity;

    public OrderProduct() {
        super();
    }

    public OrderProduct(Order order, BasketProduct basketProduct, Integer quantity) {
        pk = new OrderProductPK();
        pk.setOrder(order);
        pk.setBasketProduct(basketProduct);
        this.quantity = quantity;
    }

    public BasketProduct getProduct() {
        return this.pk.getBasketProduct();
    }

    public Double getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

    public OrderProductPK getPk() {
        return pk;
    }

    public void setPk(OrderProductPK pk) {
        this.pk = pk;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pk == null) ? 0 : pk.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OrderProduct other = (OrderProduct) obj;
        if (pk == null) {
            if (other.pk != null) {
                return false;
            }
        } else if (!pk.equals(other.pk)) {
            return false;
        }

        return true;
    }
}
