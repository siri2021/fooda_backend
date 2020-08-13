package be.fooda.backend.commons.model.template.product.request;

import java.util.Date;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "product_media")
public class FoodaProductMedia {
    
    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_product")
    private FoodaProductKey productKey;

    @Id
    @Column(name = "media_id")
    private Integer mediaId;

    @Column(name = "url")
    private String url;

    @Column(name = "extension")
    private String extension;

    @Column(name = "is_featured")
    private Boolean isFeatured;
    
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "registry_date")
    private Date registryDate;
}
