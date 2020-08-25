package be.fooda.backend.commons.model.template.order.dto;

import lombok.*;
import javax.persistence.*;

import be.fooda.backend.commons.model.template.FoodaAbstractDto;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@Table(name = "ORDER_STATUS")
public class FoodaOrderStatusDto extends FoodaAbstractDto {
    @Id
    private Long statusId;
    private String title;
    private FoodaOrderStatusDto parent;
}