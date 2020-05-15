package it.vkod.woo.store.service.payloads.store.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@JsonAutoDetect
@NoArgsConstructor
public class WooStoreResponse implements Serializable {

    @Getter
    @Setter
    private long storeId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String url;

}
