package it.vkod.fooda.customer.frontend.models.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class OrderResponseCollectionItem {
    @Getter
    @Setter
    private String href;
}
