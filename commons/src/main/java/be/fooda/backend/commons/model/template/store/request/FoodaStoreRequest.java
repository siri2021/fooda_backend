package be.fooda.backend.commons.model.template.store.request;

import be.fooda.backend.commons.model.template.media.request.FoodaMediaRequest;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "STORE")
public class FoodaStoreRequest {

    private Long storeId;

    private String name;

    private String slogan;

    private FoodaMediaRequest bgImage;

    private FoodaMediaRequest bgVideo;
}