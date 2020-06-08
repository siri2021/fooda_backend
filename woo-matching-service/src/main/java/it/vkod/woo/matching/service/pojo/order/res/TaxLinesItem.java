package it.vkod.woo.matching.service.pojo.order.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class TaxLinesItem {
    @Getter
    @Setter
    private String taxTotal;
    @Getter
    @Setter
    private int rateId;
    @Getter
    @Setter
    private List<Object> metaData;
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String label;
    @Getter
    @Setter
    private String rateCode;
    @Getter
    @Setter
    private boolean compound;
    @Getter
    @Setter
    private String shippingTaxTotal;
}