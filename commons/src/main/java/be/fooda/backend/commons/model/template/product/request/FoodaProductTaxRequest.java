package be.fooda.backend.commons.model.template.product.request;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import be.fooda.backend.commons.model.template.querable.FoodaQuerable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "PRODUCT_TAX")
public class FoodaProductTaxRequest extends FoodaQuerable {
    
    @Id
    @Column(name = "tax_id")
    private Integer taxId;

    @Column(name = "key_id")
    @OneToOne(mappedBy = "product_tax", cascade = CascadeType.ALL)
    private FoodaProductKeyRequest keyId;

    @Column(name = "title")
    private String title;

    @Column(name = "percentage")
    private BigDecimal percentage;

}