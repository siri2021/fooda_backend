package be.fooda.backend.commons.model.template.product.response;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaProductResponse{
    
    private FoodaProductKey key;
    
    private String name;

    private List<FoodaProductPrice> priceList;

    private List<FoodaProductTax> taxList;

    private Integer orderLimit;

    private String decription;

    private FoodaProductType type;

    private List<FoodaProductMedia> mediaList;

    private Boolean isFeatured;
    
    private Boolean isActive;

    private Date registryDate;
    
}