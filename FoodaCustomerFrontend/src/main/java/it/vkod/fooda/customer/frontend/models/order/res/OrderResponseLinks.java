package it.vkod.fooda.customer.frontend.models.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@NoArgsConstructor
public class OrderResponseLinks {
    @Getter
    @Setter
    private List<OrderResponseSelfItem> self;
    @Getter
    @Setter
    private List<OrderResponseCollectionItem> collection;
}