package be.fooda.backend.commons.model.woocommerce.product.shipping_classes.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Links {

    @JsonProperty("self")
    private List<SelfItem> self;

    @JsonProperty("collection")
    private List<CollectionItem> collection;
}