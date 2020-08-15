package be.fooda.backend.commons.model.template.product.request;

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
@Table(name = "PRODUCT")
public class FoodaProductRequest extends FoodaQuerable{
    
    @Id
    @Column(name = "key_id")
    private FoodaProductKeyRequest keyId;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private FoodaProductPriceRequest price;

    @Column(name = "order_limit")
    private Integer orderLimit;

    @Column(name = "description")
    private String description;

    @Column(name = "is_featured")
    private Boolean isFeatured;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private FoodaProductTypeRequest type;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private FoodaProductTaxRequest tax;

    @Column(name = "image_id")
    private Integer imageId;

}