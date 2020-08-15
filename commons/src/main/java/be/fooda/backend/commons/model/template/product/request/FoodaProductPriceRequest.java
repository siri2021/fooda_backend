package be.fooda.backend.commons.model.template.product.request;

import java.math.BigDecimal;
import java.sql.Date;

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
@Table(name = "PRODUCT_PRICE")
public class FoodaProductPriceRequest extends FoodaQuerable {
    
    @Id
    @Column(name = "price_id")
    private Integer priceId;

    @Column(name = "key_id")
    private FoodaProductKeyRequest keyId;

    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "description")
    private String description;

    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;

}