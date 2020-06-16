package it.vkod.fooda.customer.frontend.models.product.request;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImagesItem {
    @Getter
    @Setter
    private String dateModifiedGmt;
    @Getter
    @Setter
    private String dateModified;
    @Getter
    @Setter
    private String src;
    @Getter
    @Setter
    private String dateCreated;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String alt;
    @Getter
    @Setter
    private String dateCreatedGmt;
    @Getter
    @Setter
    private int id;

}