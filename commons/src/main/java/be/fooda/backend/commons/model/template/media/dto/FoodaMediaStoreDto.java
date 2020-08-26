package be.fooda.backend.commons.model.template.media.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@Entity
@Table(name = "STORE_MEDIA")
public class FoodaMediaStoreDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeMediaId;
    @NotNull
    private Long storeId;
    private FoodaMediaTypeDto type;
    @NotNull
    private String url;
}
