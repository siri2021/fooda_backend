package be.fooda.backend.commons.model.template.store.response;


import java.time.LocalDate;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FoodaStorePaymentMethodsItemRes {
    private String title;
    private Double minOrderAmount;
    private LocalDate expiry;
}