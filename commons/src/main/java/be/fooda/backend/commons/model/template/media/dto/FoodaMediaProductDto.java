package be.fooda.backend.commons.model.template.media.dto;

import be.fooda.backend.commons.model.template.product.dto.FoodaProductKeyDto;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "PRODUCT_MEDIA")
public class FoodaMediaProductDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long productMediaId;
    private FoodaProductKeyDto productKey;
    private FoodaMediaTypeDto type;
    @NotNull
    private String url;
}