package be.fooda.backend.commons.model.woocommerce.product.variations.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Dimensions {

    @JsonProperty("length")
    private String length;

    @JsonProperty("width")
    private String width;

    @JsonProperty("height")
    private String height;
}