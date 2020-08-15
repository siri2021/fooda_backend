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
@Table(name = "PRODUCT_TYPE")
public class FoodaProductTypeRequest extends FoodaQuerable {
    
    @Id
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "name")
    private String name;

}