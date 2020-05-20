package it.vkod.woo.auth.service.pojo.res;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    @Getter
    @Setter
    private Boolean success;

    @Getter
    @Setter
    private String message;
}
