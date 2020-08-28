package be.fooda.backend.media.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MEDIA_TYPE")
public class FoodaMediaTypeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long typeId;
    @NotNull
    private String title;
    private String extension;
}
