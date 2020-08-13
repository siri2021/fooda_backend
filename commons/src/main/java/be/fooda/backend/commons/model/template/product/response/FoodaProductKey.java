package be.fooda.backend.commons.model.template.product.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaProductKey implements Serializable {

    private static final long serialVersionUID = 1395404097184878469L;

    private Integer productId;

    private Integer storeId;
}