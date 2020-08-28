package be.fooda.backend.media.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "APP_SOURCE_MEDIA")
public class FoodaMediaAppDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeMediaId;
    private Long appSourceId;
    private FoodaMediaTypeDto type;
    @NotNull
    private String url;
}
