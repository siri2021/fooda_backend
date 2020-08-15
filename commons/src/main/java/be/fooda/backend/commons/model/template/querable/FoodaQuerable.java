package be.fooda.backend.commons.model.template.querable;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public abstract class FoodaQuerable {
    
    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "registryDate")
    private Date registryDate;
    
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;
}