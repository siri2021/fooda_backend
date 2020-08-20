package be.fooda.backend.commons.model.template.store.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

VideosItemReqstructor
@Getter
@Setter
public class VideosItemReq {

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;
}