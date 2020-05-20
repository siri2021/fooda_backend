package it.vkod.woo.store.generator.service.pojo.store.req;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
@EqualsAndHashCode
@ToString
public class StoreRequest implements Serializable {

    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String phone;

}
