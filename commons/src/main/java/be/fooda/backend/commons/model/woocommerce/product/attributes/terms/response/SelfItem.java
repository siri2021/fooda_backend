package be.fooda.backend.commons.model.woocommerce.product.attributes.terms.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SelfItem {

    @JsonProperty("href")
    private String href;
}