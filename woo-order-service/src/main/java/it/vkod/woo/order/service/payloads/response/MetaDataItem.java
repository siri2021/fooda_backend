package it.vkod.woo.order.service.payloads.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
public class MetaDataItem {
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
