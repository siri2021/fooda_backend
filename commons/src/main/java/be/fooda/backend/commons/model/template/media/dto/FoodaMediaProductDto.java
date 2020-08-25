package be.fooda.backend.commons.model.template.media.dto;

import lombok.*;
import javax.persistence.*;

import be.fooda.backend.commons.model.template.product.dto.FoodaProductKeyDto;

@Data
@Builder
@Entity
@Table(name = "PRODUCT_MEDIA")
public class FoodaMediaProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productMediaId;
    private FoodaProductKeyDto productKey;
    private FoodaMediaTypeDto type;
    private String url;
}