package be.fooda.backend.commons.model.woocommerce.product.variations.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Builder
public class WooCommerceProductVariationRequest {

    @JsonProperty("regular_price")
    private String regularPrice;

    @JsonProperty("image")
    private Image image;

    @JsonProperty("attributes")
    private List<AttributesItem> attributes;
}