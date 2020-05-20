package it.vkod.woo.order.service.payloads.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class CollectionItem {
    @Getter
    @Setter
    private String href;
}
