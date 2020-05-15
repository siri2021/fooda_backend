package it.vkod.woo.store.service.payloads.store.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonAutoDetect
@NoArgsConstructor
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
