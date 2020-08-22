package be.fooda.backend.commons.model.template.order.dto;

import lombok.*;
import javax.persistance.*;

@Data
@Builder
@Entity
@Table(name = "ORDER_STATUS")
public class FoodaOrderStatusDto {
    @Id
    private Long statusId;
    private String title;
    private FoodaOrderStatusDto parent;
}