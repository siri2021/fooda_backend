package be.fooda.backend.commons.model.woocommerce.product.shipping_classes.response;

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