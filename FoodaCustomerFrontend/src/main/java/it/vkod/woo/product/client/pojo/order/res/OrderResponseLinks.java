package it.vkod.woo.product.client.pojo.order.res;

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