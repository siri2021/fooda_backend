package be.fooda.backend.commons.model.template.media.request;

import be.fooda.backend.commons.model.template.store.request.FoodaStoreRequest;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "STORE_MEDIA")
public class FoodaMediaRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mediaId;

    private FoodaStoreRequest store;

    private FoodaMediaTypeRequest type;

    private String url;
}