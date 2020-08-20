package be.fooda.backend.commons.model.woocommerce.product.categories.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Image {

    @JsonProperty("src")
    private String src;
}