package it.vkod.woocommerce.server.models.order.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class CollectionItem {
    @Getter
    @Setter
    private String href;
}
