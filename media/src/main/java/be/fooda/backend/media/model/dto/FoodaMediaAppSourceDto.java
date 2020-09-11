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
@Table(name = "APP_SOURCE")
public class FoodaMediaAppSourceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appSourceId;
    private String title;
    @NotNull
    private String url;
    private String resolution;
    private Boolean mustBeCached;
}