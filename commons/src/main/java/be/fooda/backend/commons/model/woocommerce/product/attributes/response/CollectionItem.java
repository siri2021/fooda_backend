package be.fooda.backend.commons.model.woocommerce.product.attributes.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CollectionItem {

    @JsonProperty("href")
    private String href;
}