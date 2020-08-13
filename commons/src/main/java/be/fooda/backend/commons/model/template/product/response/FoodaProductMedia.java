package be.fooda.backend.commons.model.template.product.response;

import java.util.Date;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FoodaProductMedia {

    private FoodaProductKey productKey;

    private Integer mediaId;

    private String url;

    private String extension;

    private Boolean isFeatured;

    private Boolean isActive;

    private Date registryDate;
}
