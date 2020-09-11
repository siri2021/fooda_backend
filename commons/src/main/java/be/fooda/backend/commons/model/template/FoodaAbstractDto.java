package be.fooda.backend.commons.model.template;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class FoodaAbstractDto implements java.io.Serializable {
    private LocalDate registeredAt;
    private LocalDate updatedAt;
    private Boolean isActive;
}
