package be.fooda.backend.commons.model.template;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public abstract class FoodaAbstractDto implements java.io.Serializable {
    private LocalDateTime registeredAt;
    private LocalDateTime updatedAt;
    private Boolean isActive;
}
