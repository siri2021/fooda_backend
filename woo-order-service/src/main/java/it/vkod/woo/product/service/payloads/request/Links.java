package it.vkod.woo.product.service.payloads.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
public class Links {
    @Getter
    @Setter
    private List<SelfItem> self;
    @Getter
    @Setter
    private List<CollectionItem> collection;
}