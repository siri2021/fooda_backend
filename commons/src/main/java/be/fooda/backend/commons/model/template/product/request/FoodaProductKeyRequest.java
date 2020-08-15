package be.fooda.backend.commons.model.template.product.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import be.fooda.backend.commons.model.template.querable.FoodaQuerable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "PRODUCT_KEY")
public class FoodaProductKeyRequest extends FoodaQuerable {
    
    @Id
    @Column(name = "key_id")
    private Integer keyId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "store_id")
    private Integer storeId;

}