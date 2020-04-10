package it.vkod.wp.content.server.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostRequest implements Serializable {

    private String content;
    private String title;
    private String excerpt;

    public PostRequest() {
    }

    public PostRequest(String content, String title, String excerpt) {
        this.content = content;
        this.title = title;
        this.excerpt = excerpt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }
}
