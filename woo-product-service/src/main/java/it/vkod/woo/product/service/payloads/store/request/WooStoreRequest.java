package it.vkod.woo.product.service.payloads.store.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
public class WooStoreRequest implements Serializable {

    @Getter
    @Setter
    private long storeId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String consumerSecret;
    @Getter
    @Setter
    private String consumerKey;
    @Getter
    @Setter
    private String url;

}
