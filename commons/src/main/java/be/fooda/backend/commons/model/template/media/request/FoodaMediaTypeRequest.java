package be.fooda.backend.commons.model.template.media.request;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "MEDIA_TYPE")
public class FoodaMediaTypeRequest {

    private Long typeId;

    private String title;

    private String extension;
}