package be.fooda.backend.commons.model.template.product.request;

import java.util.Date;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "product_type")
public class FoodaProductType {

    @EmbeddedId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_product")
    private FoodaProductKey productKey;

    @Id
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "title")
    private String title;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "registry_date")
    private Date registryDate;
}