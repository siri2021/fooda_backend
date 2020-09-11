package be.fooda.backend.matching.view;

import be.fooda.backend.commons.model.template.matching.response.FoodaMatchRes;
import be.fooda.backend.commons.service.mapper.FoodaMatchingHttpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/match")
public class FoodaMatchingController {

    @Autowired
    private FoodaMatchingHttpMapper matchingMapper;

    @GetMapping
    public ResponseEntity<List<FoodaMatchRes>> apiGetMatchProduct(@RequestBody @Valid final Object req) {
        return null;
    }
}
