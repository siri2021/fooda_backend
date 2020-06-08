package it.vkod.woo.matching.service.pojo.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
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
