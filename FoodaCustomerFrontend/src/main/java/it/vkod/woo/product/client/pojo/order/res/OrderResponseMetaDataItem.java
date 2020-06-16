package it.vkod.woo.product.client.pojo.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class OrderResponseMetaDataItem {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String value;
    @Getter
    @Setter
    private String key;
}
