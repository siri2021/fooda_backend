package be.fooda.backend.commons.model.template.product.request;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "product")
public class FoodaProductRequest{
    
    @EmbeddedId
    private FoodaProductKey key;
    
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product")
    private List<FoodaProductPrice> priceList;

    @OneToMany(mappedBy = "product")
    private List<FoodaProductTax> taxList;

    @Column(name = "order_limit")
    private Integer orderLimit;

    @Column(name = "description")
    private String decription;

    @OneToOne(mappedBy = "product")
    private FoodaProductType type;

    @OneToMany(mappedBy = "product")
    private List<FoodaProductMedia> mediaList;

    @Column(name = "is_featured")
    private Boolean isFeatured;
    
}