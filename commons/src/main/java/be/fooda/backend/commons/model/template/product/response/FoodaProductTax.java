package be.fooda.backend.commons.model.template.product.response;

import java.util.Date;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaProductTax {

    private FoodaProductKey productKey;

    private Integer taxId;

    private String title;

    private Double percentage;

    private Boolean isDefault;

    private Boolean isActive;

    private Date registryDate;
}
