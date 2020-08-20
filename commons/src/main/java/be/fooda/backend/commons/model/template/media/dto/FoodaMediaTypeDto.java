package be.fooda.backend.commons.model.template.media.dto;

import lombok.Builder;
import lombok.Data;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "MEDIA_TYPE")
public class FoodaMediaTypeDto {

    @Id
    @GeneratedValue(strategy = GeneratedValue.AUTO)
    private Long typeId;

    private String title;

    private String extension;
}
