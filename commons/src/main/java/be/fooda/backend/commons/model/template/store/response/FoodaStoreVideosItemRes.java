package be.fooda.backend.commons.model.template.store.response;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class FoodaStoreVideosItemRes {
    private String title;
    private String url;
}