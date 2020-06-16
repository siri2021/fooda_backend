package it.vkod.woocommerce.server.models.order.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Links {
    @Getter
    @Setter
    private List<SelfItem> self;
    @Getter
    @Setter
    private List<CollectionItem> collection;
}