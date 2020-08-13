package be.fooda.backend.commons.model.template.product.response;

import java.util.Date;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaProductType {

    private FoodaProductKey productKey;

    private Integer typeId;

    private String title;

    private Boolean isActive;

    private Date registryDate;
}
