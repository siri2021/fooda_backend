package be.fooda.backend.commons.model.template.product.request;

import java.util.Date;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "product_tax")
public class FoodaProductTax {

    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_product")
    private FoodaProductKey productKey;

    @Column(name = "tax_id")
    private Integer taxId;

    @Column(name = "title")
    private String title;

    @Column(name = "percentage")
    private Double percentage; 

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "registry_date")
    private Date registryDate;
}
