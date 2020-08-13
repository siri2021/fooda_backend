package be.fooda.backend.commons.model.template.product.request;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class FoodaProductKey implements Serializable{

    private static final long serialVersionUID = 1395404097184878469L;

    @Column(name = "product_id")
    private Integer productId;
    
    @Column(name = "store_id")
    private Integer storeId;
}